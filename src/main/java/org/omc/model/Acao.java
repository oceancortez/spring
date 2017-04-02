package org.omc.model;

import org.omc.constant.AcaoE;

public class Acao {
	
	private AcaoE acaoE;

	public AcaoE getAcaoE() {
		return acaoE;
	}

	public void setAcaoE(AcaoE acaoE) {
		this.acaoE = acaoE;
	}
	
	public boolean isAdd(){
		return AcaoE.ADD.equals(acaoE);
	}
	
	public boolean isUpdate(){
		return AcaoE.UPDATE.equals(acaoE);
	}
	
	
	

}
