package com.itech.iERP.forms;

import org.apache.struts.action.ActionForm;

public class ExpenseTypeMasterForm extends ActionForm
{
  private int expenseId;
  private String expensename;
  private boolean active;
public int getExpenseId() {
	return expenseId;
}
public void setExpenseId(int expenseId) {
	this.expenseId = expenseId;
}

public String getExpensename() {
	return expensename;
}
public void setExpensename(String expensename) {
	this.expensename = expensename;
}
public boolean isActive() {
	return active;
}
public void setActive(boolean active) {
	this.active = active;
}
}
