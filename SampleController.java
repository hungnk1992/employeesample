package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

public class SampleController {
	
	ObservableList<String> mGenders = FXCollections.observableArrayList("Gender", "Male", "Female");
	
	ObservableList<Integer> mEmpNum = FXCollections.observableArrayList(5, 10, 15);
	
	ObservableList<Employee> mEmployees = FXCollections.observableArrayList();
	
	EmployeeManagement mEmployeeManagement;
	
	@FXML
	private ChoiceBox<String> idEmpGender;
	
	@FXML
	private ComboBox<Integer> idEmpNum;
	
	@FXML
	private TextArea idContent;
	
	private void loadGenderData() {
				
		idEmpGender.getItems().addAll(mGenders);
		
		idEmpGender.getSelectionModel().selectFirst();
		
		idEmpNum.getItems().addAll(mEmpNum);
		
		
	}

	public void initialize() {
		
		System.out.println(" == LOAD DATA");
		
		mEmployeeManagement = new EmployeeManagement();
		
		loadGenderData();
				
		System.out.println (" == Loading completed!");
	}
	
	public void confirm() {
		
		String gender = idEmpGender.getValue();
		
		if (gender == "Gender") {
			
			gender = "A";
			
		} else if (gender == "Male") {
			
			gender = "M";
			
		} else {
			
			gender = "F";
					
		}
		
		Integer empNum = 0;
		
		if (idEmpNum.getValue() != null) {
			
			empNum = idEmpNum.getValue();
			
		}
		
		System.out.println ("DISPLAY: "
							+ empNum + " employees "
							+ " and gender is " + gender
				);
		
		
		
		System.out.println (" === START collect");
		
		mEmployeeManagement.collectEmployees(empNum, gender);
		
		idContent.setText("");
		
		idContent.setText(mEmployeeManagement.toString());		
		
	}
	
}
