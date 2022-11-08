package com.gussoft.signdata.controller;

import com.gussoft.signdata.models.SignatureModel;
import com.gussoft.signdata.utils.JobBuilder;
import com.gussoft.signdata.utils.SigningTask;
import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.Region;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import eu.europa.esig.dss.enumerations.DigestAlgorithm;
import eu.europa.esig.dss.enumerations.SignatureLevel;
import eu.europa.esig.dss.enumerations.SignaturePackaging;
import eu.europa.esig.dss.enumerations.SignatureTokenType;
import eu.europa.esig.dss.model.DSSDocument;
import eu.europa.esig.dss.tsl.job.TLValidationJob;
import eu.europa.esig.dss.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SignatureController extends Component {

    private static final Logger log = LoggerFactory.getLogger(SignatureController.class);

    private SignatureModel model;

    private JobBuilder jobBuilder;

    private TLValidationJob tlValidationJob;


    public static void main(String[] args) throws Exception {

        System.out.println("Welcome to the Jungle!");

        SignatureController signto = new SignatureController();
        signto.init();
        List<File> list = signto.getFilesForSignature();

        signto.FilesToSign(list);

    }

    public DSSDocument FilesToSign(List<File> list) throws Exception {
        if (list.size() == 0) {
            System.exit(0);
        }
        model.setSignatureLevel(SignatureLevel.PAdES_BASELINE_B);
        model.setDigestAlgorithm(DigestAlgorithm.SHA256);
        model.setSignaturePackaging(SignaturePackaging.ENVELOPED);

        model.setTokenType(SignatureTokenType.MSCAPI);
        model.getFileToSignList().forEach(System.out::println);

        SigningTask task = new SigningTask(model, jobBuilder.getCertificateSources());
        for (File file : model.getFileToSignList()) {
            model.setFileToSign(file);
            DSSDocument document = task.call();
            if (document != null) {
                save(document);
                log.info("Save document in : " + document.getName());
            }
        }

        return null;

    }

    public void init() {
        model = new SignatureModel();

        //Create JobBuilder && TLValidationJob
        jobBuilder = new JobBuilder();
        tlValidationJob = jobBuilder.job();
        tlValidationJob.offlineRefresh();
        updateLabelText();
    }

    private void updateLabelText() {
        String nbCertificatesTest = "Number of Trusted Certificates : ";
        String name_cert = nbCertificatesTest + jobBuilder.getCertificateSources().getNumberOfCertificates();
    }

    private List<File> getFilesForSignature() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setMultiSelectionEnabled(true);
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "PDF Document", "pdf");
        fileChooser.setFileFilter(filter);
        int returnVal = fileChooser.showOpenDialog(this);
        File[] files = fileChooser.getSelectedFiles();
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            model.setFileToSignList(List.of(files));
            return List.of(files);
        } else {
            return new ArrayList<>();
        }
    }

    private void save(DSSDocument signedDocument) {
/*        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialFileName(signedDocument.getName());
        MimeType mimeType = signedDocument.getMimeType();

        String extension = MimeType.getExtension(mimeType);
        String filterPattern = extension != null ? "*." + extension : "*";
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(mimeType.getMimeTypeString(), filterPattern);
        fileChooser.getExtensionFilters().add(extFilter);*/
        JFileChooser chooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        int returnValue = chooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File fileToSave = chooser.getSelectedFile();
            try (FileOutputStream fos = new FileOutputStream(fileToSave)) {
                Utils.copy(signedDocument.openStream(), fos);
            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Unable to save file : " + e.getMessage(), ButtonType.CLOSE);
                alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
                alert.showAndWait();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Accion Cancelada por el Usuario");
        }

    }
}
