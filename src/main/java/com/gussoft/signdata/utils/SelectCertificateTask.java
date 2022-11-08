package com.gussoft.signdata.utils;

import eu.europa.esig.dss.model.x509.CertificateToken;
import eu.europa.esig.dss.spi.DSSASN1Utils;
import eu.europa.esig.dss.token.DSSPrivateKeyEntry;
import javafx.scene.control.ChoiceDialog;

import javax.swing.*;
import java.util.*;
import java.util.concurrent.Callable;

public class SelectCertificateTask implements Callable<DSSPrivateKeyEntry> {

	private List<DSSPrivateKeyEntry> keys;

	public SelectCertificateTask(List<DSSPrivateKeyEntry> keys) {
		this.keys = keys;
	}

	@Override
	public DSSPrivateKeyEntry call() {
		Map<String, DSSPrivateKeyEntry> map = new HashMap<>();
		for (DSSPrivateKeyEntry dssPrivateKeyEntry : keys) {
			CertificateToken certificate = dssPrivateKeyEntry.getCertificate();
			String text = DSSASN1Utils.getHumanReadableName(certificate) + " (" + certificate.getSerialNumber() + ")";
			map.put(text, dssPrivateKeyEntry);
		}
		String[] keySet = map.keySet().toArray(new String[0]);

		String input = (String) JOptionPane.showInputDialog(null, "Select your certificate",
				"Mensaje del Sistema - SignData", JOptionPane.QUESTION_MESSAGE, null, // Use
				// default
				// icon
				keySet, // Array of choices
				keySet[0]);
		if (input == null) {
			return null;
		}
		Optional<String> result = Optional.of(input);//dialog.showAndWait();

		if (result.isPresent()) {
			return map.get(result.get());
		}
		return null;
	}

}
