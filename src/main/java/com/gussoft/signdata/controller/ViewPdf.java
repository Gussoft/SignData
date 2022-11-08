package com.gussoft.signdata.controller;

import org.icepdf.ri.common.ComponentKeyBinding;
import org.icepdf.ri.common.SwingController;
import org.icepdf.ri.common.SwingViewBuilder;
import org.icepdf.ri.util.FontPropertiesManager;
import org.icepdf.ri.util.ViewerPropertiesManager;

import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;

public class ViewPdf {

    private static final Dimension ScreenSize = Toolkit.getDefaultToolkit().getScreenSize();


    public static void main(String[] args) throws MalformedURLException {
        String filePath = "C:\\Users\\GHUAMABE\\Desktop\\dd.pdf";
        SwingController controller = new SwingController();
        //FontPropertiesManager.getInstance().loadOrReadSystemFonts();

        ViewerPropertiesManager props = ViewerPropertiesManager.getInstance();

        props.setBoolean(ViewerPropertiesManager.PROPERTY_SHOW_TOOLBAR_ANNOTATION, false);
        props.set(ViewerPropertiesManager.PROPERTY_DEFAULT_ZOOM_LEVEL, "1.00");
        // to never display the "ICEpdf Properties Manager" dialog
        props.getPreferences().putBoolean("application.showLocalStorageDialogs", false);
        props.setBoolean(ViewerPropertiesManager.PROPERTY_SHOW_TOOLBAR_PAGENAV, Boolean.TRUE);
        props.setBoolean(ViewerPropertiesManager.PROPERTY_SHOW_TOOLBAR_TOOL, false);
        props.setBoolean(ViewerPropertiesManager.PROPERTY_SHOW_TOOLBAR_ZOOM, false);
        props.setBoolean(ViewerPropertiesManager.PROPERTY_SHOW_UTILITYPANE_SEARCH, false);
        props.setBoolean(ViewerPropertiesManager.PROPERTY_SHOW_TOOLBAR_SEARCH, false);
        props.setBoolean(ViewerPropertiesManager.PROPERTY_SHOW_TOOLBAR_ROTATE, Boolean.FALSE);
        props.setBoolean(ViewerPropertiesManager.PROPERTY_SHOW_TOOLBAR_FIT, Boolean.FALSE);

        SwingViewBuilder factory = new SwingViewBuilder(controller, props);


        JPanel viewerComponentPanel = factory.buildViewerPanel();


        ComponentKeyBinding.install(controller, viewerComponentPanel);

        controller.getDocumentViewController().setAnnotationCallback(
                new org.icepdf.ri.common.MyAnnotationCallback(
                        controller.getDocumentViewController()));


        JFrame window = new JFrame("View Document :: " + filePath);
        window.getContentPane().add(viewerComponentPanel);
        window.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        window.addWindowListener(controller);
        window.setSize(new Dimension((int) (ScreenSize.getWidth() / 2), (int) (ScreenSize.getHeight() / 2)));
        window.setExtendedState(JFrame.MAXIMIZED_BOTH);
        window.pack();
        window.setVisible(true);
        URL url = new URL("https://biblioteca.org.ar/libros/656228.pdf");

        //controller.openDocument(url);
        controller.openDocument(filePath);
    }
}
