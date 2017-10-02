package com.tuyendev.component;

import com.tuyendev.common.JSFUtil;
import java.io.Serializable;

import javax.faces.event.ActionEvent;

import oracle.adf.share.logging.ADFLogger;
import oracle.adf.view.rich.component.rich.RichPopup;

public class ExtendedPopupHandler implements Serializable {

    protected final static ADFLogger logger = ADFLogger.createADFLogger(ExtendedPopupHandler.class);

    public void onClose(ActionEvent actionEvent) {
        try {
            RichPopup currentPopup = (RichPopup) actionEvent.getComponent()
                                                            .getAttributes()
                                                            .get("ppbd");
            JSFUtil.clientScript("invokeBFC()");
            currentPopup.hide();
        } catch (Exception e) {
            logger.severe(e.getMessage());
        }
    }
    
    public void onOpen(RichPopup currentPopup){
        try {
            JSFUtil.clientScript("invokeBFO()");
            currentPopup.show(new RichPopup.PopupHints());
        } catch (Exception e) {
            logger.severe(e.getMessage());
        }
    }
}
