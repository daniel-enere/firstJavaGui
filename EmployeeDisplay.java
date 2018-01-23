package com.enerecorp.client;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

import com.enerecorp.hr.*;

public class EmployeeDisplay extends JFrame{
	String firstName, lastName;
	Employee regEmployee = new Employee();
	//first row
	JPanel empNameRow = new JPanel();
	JTextField employeeFirstName = new JTextField(20);
	JTextField employeeLastName = new JTextField(20);
	//second row
	JPanel salaryInputRow = new JPanel();
	JTextField maxEmpHoursField = new JTextField(20);
	JTextField salaryField = new JTextField(15);
	JTextField benefitsField = new JTextField(25);
	
	//third row
	JPanel SexRow = new JPanel();
	ButtonGroup sexOption = new ButtonGroup();
	JCheckBox maleOption = new JCheckBox("Male", true);
	JCheckBox femaleOption = new JCheckBox("Female", false);
	
	//fourth row
	JPanel buttonRow = new JPanel();
	JButton saveButton = new JButton("Save");
	
	public EmployeeDisplay() {
		setLookAndFeel();
		setSize(700, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridLayout frameLayout = new GridLayout(5,1,10,10);
		setLayout(frameLayout);
		
		//first row construction
		GridLayout empNameLayout = new GridLayout(0, 4, 10, 10);
		JLabel firstNameLabel = new JLabel("First Name", JLabel.LEFT);
		JLabel lastNameLabel = new JLabel("Last Name", JLabel.LEFT);
		empNameRow.setLayout(empNameLayout);
		empNameRow.add(firstNameLabel);
		empNameRow.add(employeeFirstName);
		empNameRow.add(lastNameLabel);
		empNameRow.add(employeeLastName);
		firstName = employeeFirstName.getText();
		regEmployee.setFirstName(firstName);
		add(empNameRow);
		
		//second row construction
		GridLayout salaryInputLayout = new GridLayout(0,6,5,10);
		JLabel salaryInputLabel = new JLabel("Salary:");
		JLabel maxEmpHoursLabel = new JLabel("Maximum Weekly Hours:");
		JLabel totalCostOfBenefitsLabel = new JLabel("Total Cost of Benefits:");
		salaryInputRow.setLayout(salaryInputLayout);
		salaryInputRow.add(maxEmpHoursLabel);
		salaryInputRow.add(maxEmpHoursField);
		salaryInputRow.add(salaryInputLabel);
		salaryInputRow.add(salaryField);
		salaryInputRow.add(totalCostOfBenefitsLabel);
		salaryInputRow.add(benefitsField);
		add(salaryInputRow);
		
		//third row construction
		FlowLayout sexLayout = new FlowLayout(FlowLayout.CENTER, 10,10);
		SexRow.setLayout(sexLayout);
		sexOption.add(femaleOption);
		sexOption.add(maleOption);
		SexRow.add(femaleOption);
		SexRow.add(maleOption);
		add(SexRow);
		
		//fourth row construction
		FlowLayout buttonLayout = new FlowLayout(FlowLayout.LEFT);
		buttonRow.setLayout(buttonLayout);
		buttonRow.add(saveButton);
		add(buttonRow);
		
		setVisible(true);
	}
	
	public void setLookAndFeel() {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		}catch (Exception err) {
			//intentionally left blank
		}
	}
	
	public static void main(String[] args) {
		new EmployeeDisplay();
		//allow for employee to be managed
		//user to calculate total cost of employees on the clock
		//user should be able to limit hours based on budget
		//user should be notified before reaching limit
	}
}
