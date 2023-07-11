package com.controllers;

import java.io.File;

import com.baitaplonoop.ExamApplication;
import com.entities.Category;
import com.entities.Option;
import com.entities.Question;
import javafx.stage.FileChooser;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;

import com.optionpanel.JOptionPaneExam1;

import javax.swing.*;

public class controllerBai34 {

    @FXML
    public Label creatnewquestion,LabelCategories,LabelQuestions,LabelIT,Import,Chooseafile;

    @FXML
    public void openBai32(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/baitaplonoop/Bai32.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void openBai33(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/baitaplonoop/Bai33.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void openBai32b(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/baitaplonoop/Bai32b.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void openBai21(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/baitaplonoop/Bai21.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    public void openBai1(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/baitaplonoop/Bai1.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void clickChooseafile(MouseEvent event) throws IOException {
        FileChooser fileChooser = new FileChooser();

        // Set extension filter
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Text files (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);

        // Show open file dialog
        File file = fileChooser.showOpenDialog(null);

        if (file != null) {
            // Do something with the file, Minh ơi, phần này t trông cậy hết vào mày thôi đó
            String filePath = file.getAbsolutePath();
            System.out.println("Selected file: " + filePath);
        }

    }

    private JFrame mainFrame;
    @FXML
    public void ImportAction() {
        JOptionPane.showMessageDialog(mainFrame,
                "Import ok!");
        List<Question> questions = new ArrayList<>();
        Question q1 = new Question("Đối với sản phẩm bảo hiểm liên kết đơn vị, phí chuyển đổi quỹ liên kết đơn vị là:");
        List<Option> options = new ArrayList<>();
        options.add(new Option("A. Khoản phí dùng để trang trải chi phí phát hành hợp đồng bảo hiểm, chi phí thẩm định bảo hiểm, chi phí kiểm tra y tế, chi hoa hồng đại lý và chi phí khác.", "0"));
        options.add(new Option("B. Khoản phí bên mua bảo hiểm phải trả cho doanh nghiệp bảo hiểm khi thực hiện chuyển đổi tài sản đầu tư giữa các quỹ liên kết đơn vị.", "100"));
        options.add(new Option("C. Khoản phí để bù đắp chi phí liên quan đến việc duy trì hợp đồng bảo hiểm và cung cấp thông tin liên quan đến hợp đồng bảo hiểm cho bên mua bảo hiểm", "0"));
        options.add(new Option("D. Khoản phí đối với quyền lợi bảo hiểm rủi ro theo cam kết tại hợp đồng bảo hiểm.", "0"));
        q1.setOptions(options);
        questions.add(q1);
        Question q2 = new Question("Theo quy định của Pháp luật, Văn phòng đại diện của doanh nghiệp bảo hiểm, doanh nghiệp môi giới bảo hiểm nước ngoài tại Việt Nam được thực hiện hoạt động nào sau đây:");
        List<Option> options2 = new ArrayList<>();
        options2.add(new Option("A. Xúc tiến xây dựng các dự án đầu tư của doanh nghiệp bảo hiểm, doanh nghiệp môi giới bảo hiểm nước ngoài.", "0"));
        options2.add(new Option("B. Thúc đẩy và theo dõi việc thực hiện các dự án do doanh nghiệp bảo hiểm, doanh nghiệp môi giới bảo hiểm nước ngoài tài trợ tại Việt Nam.", "0"));
        options2.add(new Option("C. Nghiên cứu thị trường.", "0"));
        options2.add(new Option("D. A, B, C đúng.", "100"));
        q2.setOptions(options2);
        questions.add(q2);
        Question q3 = new Question("Đại lý bảo hiểm không có quyền nào sau đây:");
        List<Option> options3 = new ArrayList<>();
        options3.add(new Option("A. Yêu cầu doanh nghiệp bảo hiểm hoàn trả tiền ký quĩ hoặc thế chấp tài sản theo thỏa thuận trong hợp đồng đại lý bảo hiểm.", "0"));
        options3.add(new Option("B. Tham dự các lớp đào tạo, bồi dưỡng, nâng cao trình độ cho đại lý bảo hiểm do doanh nghiệp bảo hiểm tổ chức.", "0"));
        options3.add(new Option("C. Ký thay khách hàng.", "100"));
        options3.add(new Option("D. Hưởng hoa hồng và các quyền, lợi ích hợp pháp khác từ hoạt động đại lý bảo hiểm.", "0"));
        q2.setOptions(options3);
        questions.add(q3);
        Category defaultCate = ExamApplication.getDefaultCategory();
        for (Question q: questions) {
            defaultCate.addQuestion(q);
        }
        ExamApplication.SaveData();
    }
}
