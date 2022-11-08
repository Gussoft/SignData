package com.gussoft.signdata.models;

import eu.europa.esig.dss.enumerations.*;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.io.File;
import java.util.List;


public class SignatureModel {

	private ObjectProperty<File> fileToSign = new SimpleObjectProperty<>();

	private ObjectProperty<List<File>> fileToSignList = new SimpleObjectProperty<>();

	private ObjectProperty<SignatureVisualMapper> signatureMapper = new SimpleObjectProperty<>();

	private ObjectProperty<String> signatureText = new SimpleObjectProperty<>();

	private ObjectProperty<String> signatureImage = new SimpleObjectProperty<>();

	private ObjectProperty<ASiCContainerType> asicContainerType = new SimpleObjectProperty<>();
	private ObjectProperty<SignatureForm> signatureForm = new SimpleObjectProperty<>();
	private ObjectProperty<SignaturePackaging> signaturePackaging = new SimpleObjectProperty<>();
	private ObjectProperty<SignatureOption> signatureOption = new SimpleObjectProperty<>();
	private ObjectProperty<SignatureLevel> signatureLevel = new SimpleObjectProperty<>();
	private ObjectProperty<DigestAlgorithm> digestAlgorithm = new SimpleObjectProperty<>();
	private ObjectProperty<SignatureTokenType> tokenType = new SimpleObjectProperty<>();

	private ObjectProperty<File> pkcsFile = new SimpleObjectProperty<>();
	private StringProperty password = new SimpleStringProperty();

	public SignatureModel() {

	}

	public File getFileToSign() {
		return fileToSign.get();
	}

	public void setFileToSign(File fileToSign) {
		this.fileToSign.set(fileToSign);
	}

	public ObjectProperty<File> fileToSignProperty() {
		return fileToSign;
	}

	public List<File> getFileToSignList() {
		return fileToSignList.get();
	}

	public ObjectProperty<List<File>> fileToSignListProperty() {
		return fileToSignList;
	}

	public void setFileToSignList(List<File> fileToSignList) {
		this.fileToSignList.set(fileToSignList);
	}

	public SignatureVisualMapper getSignatureMapper() {
		return signatureMapper.get();
	}

	public ObjectProperty<SignatureVisualMapper> signatureMapperProperty() {
		return signatureMapper;
	}

	public void setSignatureMapper(SignatureVisualMapper signatureMapper) {
		this.signatureMapper.set(signatureMapper);
	}

	public String getSignatureText() {
		return signatureText.get();
	}

	public ObjectProperty<String> signatureTextProperty() {
		return signatureText;
	}

	public void setSignatureText(String signatureText) {
		this.signatureText.set(signatureText);
	}

	public String getSignatureImage() {
		return signatureImage.get();
	}

	public ObjectProperty<String> signatureImageProperty() {
		return signatureImage;
	}

	public void setSignatureImage(String signatureImage) {
		this.signatureImage.set(signatureImage);
	}

	public SignatureForm getSignatureForm() {
		return signatureForm.get();
	}

	public void setSignatureForm(SignatureForm signatureForm) {
		this.signatureForm.set(signatureForm);
	}

	public ObjectProperty<SignatureForm> signatureFormProperty() {
		return signatureForm;
	}

	public ASiCContainerType getAsicContainerType() {
		return asicContainerType.get();
	}

	public void setAsicContainerType(ASiCContainerType asicContainerType) {
		this.asicContainerType.set(asicContainerType);
	}

	public ObjectProperty<ASiCContainerType> asicContainerTypeProperty() {
		return asicContainerType;
	}

	public SignaturePackaging getSignaturePackaging() {
		return signaturePackaging.get();
	}

	public void setSignaturePackaging(SignaturePackaging signaturePackaging) {
		this.signaturePackaging.set(signaturePackaging);
	}

	public ObjectProperty<SignaturePackaging> signaturePackagingProperty() {
		return signaturePackaging;
	}

	public SignatureOption getSignatureOption() {
		return signatureOption.get();
	}

	public void setSignatureOption(SignatureOption signatureOption) {
		this.signatureOption.set(signatureOption);
	}

	public ObjectProperty<SignatureOption> additionalObjectProperty() {
		return signatureOption;
	}

	public SignatureLevel getSignatureLevel() {
		return signatureLevel.get();
	}

	public void setSignatureLevel(SignatureLevel signatureLevel) {
		this.signatureLevel.set(signatureLevel);
	}

	public ObjectProperty<SignatureLevel> signatureLevelProperty() {
		return signatureLevel;
	}

	public DigestAlgorithm getDigestAlgorithm() {
		return digestAlgorithm.get();
	}

	public void setDigestAlgorithm(DigestAlgorithm digestAlgorithm) {
		this.digestAlgorithm.set(digestAlgorithm);
	}

	public ObjectProperty<DigestAlgorithm> digestAlgorithmProperty() {
		return digestAlgorithm;
	}

	public SignatureTokenType getTokenType() {
		return tokenType.get();
	}

	public void setTokenType(SignatureTokenType tokenType) {
		this.tokenType.set(tokenType);
	}

	public ObjectProperty<SignatureTokenType> tokenTypeProperty() {
		return tokenType;
	}

	public String getPassword() {
		return password.get();
	}

	public void setPassword(String password) {
		this.password.set(password);
	}

	public StringProperty passwordProperty() {
		return password;
	}

	public File getPkcsFile() {
		return pkcsFile.get();
	}

	public void setPkcsFile(File pkcsFile) {
		this.pkcsFile.set(pkcsFile);
	}

	public ObjectProperty<File> pkcsFileProperty() {
		return pkcsFile;
	}

}
