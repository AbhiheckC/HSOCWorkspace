package com.idsspl.webproject.model;

public class RequestModel {


	private String ClientCode;
	private String VirtualAccountNumber;
	private String Mode;
	private String UTR;
	private String SenderRemark;
	private String ClientAccountNo;
	private String Amount;
	private String PayerName;
	private String PayerAccNumber;
	private String PayerBankIFSC;
	private String PayerPaymentDate;
	private String BankInternalTransactionNumber;
	
	public String getClientCode() {
		System.out.println("get ClientCode - "+ClientCode);
		return ClientCode;
	}
	public void setClientCode(String clientCode) {
		System.out.println("set ClientCode - "+clientCode);
		this.ClientCode = clientCode;
	}
	public String getVirtualAccountNumber() {
		System.out.println("get VirtualAccountNumber - "+VirtualAccountNumber);
		return VirtualAccountNumber;
	}
	public void setVirtualAccountNumber(String virtualAccountNumber) {
		this.VirtualAccountNumber = virtualAccountNumber;
	}
	public String getMode() {
		return Mode;
	}
	public void setMode(String mode) {
		this.Mode = mode;
	}
	public String getUTR() {
		return UTR;
	}
	public void setUTR(String uTR) {
		this.UTR = uTR;
	}
	public String getSenderRemark() {
		return SenderRemark;
	}
	public void setSenderRemark(String senderRemark) {
		this.SenderRemark = senderRemark;
	}
	public String getClientAccountNo() {
		System.out.println("get ClientAccountNo - "+ClientAccountNo);
		return ClientAccountNo;
	}
	public void setClientAccountNo(String clientAccountNo) {
		this.ClientAccountNo = clientAccountNo;
	}
	public String getAmount() {
		System.out.println("get Amount - "+Amount);
		return Amount;
	}
	public void setAmount(String amount) {
		this.Amount = amount;
	}
	public String getPayerName() {
		return PayerName;
	}
	public void setPayerName(String payerName) {
		this.PayerName = payerName;
	}
	public String getPayerAccNumber() {
		return PayerAccNumber;
	}
	public void setPayerAccNumber(String payerAccNumber) {
		this.PayerAccNumber = payerAccNumber;
	}
	public String getPayerBankIFSC() {
		return PayerBankIFSC;
	}
	public void setPayerBankIFSC(String payerBankIFSC) {
		this.PayerBankIFSC = payerBankIFSC;
	}
	public String getPayerPaymentDate() {
		return PayerPaymentDate;
	}
	public void setPayerPaymentDate(String payerPaymentDate) {
		this.PayerPaymentDate = payerPaymentDate;
	}
	public String getBankInternalTransactionNumber() {
		return BankInternalTransactionNumber;
	}
	public void setBankInternalTransactionNumber(String bankInternalTransactionNumber) {
		this.BankInternalTransactionNumber = bankInternalTransactionNumber;
	}
	
	
	@Override
	public String toString() {
		return String.format(
				"Validate {ClientCode=%s, VirtualAccountNumber=%s, Mode=%s, UTR=%s, SenderRemark=%s, ClientAccountNo=%s, Amount=%s, PayerName=%s, PayerAccNumber=%s, PayerBankIFSC=%s, PayerPaymentDate=%s, BankInternalTransactionNumber=%s}",
				ClientCode, VirtualAccountNumber, Mode, UTR, SenderRemark, ClientAccountNo, Amount, PayerName,
				PayerAccNumber, PayerBankIFSC, PayerPaymentDate, BankInternalTransactionNumber);
	}
//	private Validate validate = new Validate();
//	private Validate notify = new Validate();
//	
//	public Validate getValidate() {
//		return validate;
//	}
//
//	public void setValidate(Validate validate) {
//		this.validate = validate;
//	}
//
//	public Validate getNotify() {
//		return notify;
//	}
//
//	public void setNotify(Validate notify) {
//		this.notify = notify;
//	}
	

}
