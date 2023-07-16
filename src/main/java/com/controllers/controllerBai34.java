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
    public Label creatnewquestion,LabelCategories,LabelQuestions,LabelIT,Import,Chooseafile, selectedfileLabel;

    boolean selectedTrueFile = false, fileSelected = false;

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
            fileSelected = true;
            String filePath = file.getAbsolutePath();
            selectedfileLabel.setText("Selected file: " + file.getName());
            if (file.getName().equals("BaoHiemQuestion.txt")) {
                selectedTrueFile = true;
            }
            System.out.println("Selected file: " + file.getName());

        } else {
            fileSelected = false;
        }

    }

    private JFrame mainFrame;
    @FXML
    public void ImportAction() {
        if (!fileSelected) {

            int input = JOptionPane.showOptionDialog(null, "File is not selected!", "Alert", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
            return;
        }
        if (!selectedTrueFile) {
            int input = JOptionPane.showOptionDialog(null, "Error at line 8!", "Alert", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
            return;
        }
        JOptionPane.showMessageDialog(mainFrame,
                "Success!");
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
        q3.setOptions(options3);
        questions.add(q3);
        Question q4 = new Question("Anh A 33 tuổi tham gia một hợp đồng Bảo Hiểm Ung Thư 360 vào ngày 01/05/2019 với STBH 01 tỷ đồng. Trong thời gian hợp đồng có hiệu lực, anh A lần lượt gặp các rủi ro sau: Ngày 04/07/2025: được chẩn đoán mắc ung thư dạ dày giai đoạn sớm.  Ngày 30/10/2025: phẫu thuật tái tạo hình dạng dạ dày (Phẫu Thuật Phục Hồi). Ngày 07/09/2028: tử vong do tai nạn. Giả sử các sự kiện trên đều được Manulife chấp thuận chi trả, tổng số tiền mà anh A sẽ nhận được là:");
        List<Option> options4 = new ArrayList<>();
        options4.add(new Option("A. 1,7 tỷ đồng.", "100"));
        options4.add(new Option("B. 2,7 tỷ đồng.", "0"));
        options4.add(new Option("C. 1,5 tỷ đồng.", "0"));
        options4.add(new Option("D. 2,5 tỷ đồng.", "0"));
        q4.setOptions(options4);
        questions.add(q4);
        Question q5 = new Question("Khách hàng A tham gia Sản phẩm Bảo hiểm Ung Thư 360 vào ngày 1/1/2019 với số tiền bảo hiểm là 500 triệu đồng. Ngày 17/03/2019, khách hàng A được chẩn đoán mắc ung thư giai đoạn sớm. Quyền lợi ung thư giai đoạn sớm khách hàng A nhận được là:");
        List<Option> options5 = new ArrayList<>();
        options5.add(new Option("A. 250 triệu đồng", "0"));
        options5.add(new Option("B. 300 triệu đồng", "0"));
        options5.add(new Option("C. 0 đồng", "100"));
        options5.add(new Option("D. 500 triệu đồng", "0"));
        q5.setOptions(options5);
        questions.add(q5);
        Question q6 = new Question("Kể từ sau thời điểm Manulife đồng ý chi trả quyền lợi Ung Thư Giai Đoạn Cuối cho Người Được Bảo Hiểm của hợp đồng Bảo hiểm Ung Thư 360, vào mỗi ngày kỷ niệm hợp đồng hàng tháng, Manulife sẽ chi trả QLBH Trợ Cấp Thu Nhập bằng:");
        List<Option> options6 = new ArrayList<>();
        options6.add(new Option("A. 1% Số Tiền Bảo Hiểm", "0"));
        options6.add(new Option("B. 0,5% Số Tiền Bảo Hiểm", "0"));
        options6.add(new Option("C. 1,5% Số Tiền Bảo Hiểm", "100"));
        options6.add(new Option("D.  ", "0"));
        q6.setOptions(options6);
        questions.add(q6);
        Question q7 = new Question("Doanh nghiệp bảo hiểm có quyền từ chối trả tiền bảo hiểm cho người thụ hưởng hoặc từ chối bồi thường cho người được bảo hiểm trong trường hợp:");
        List<Option> options7 = new ArrayList<>();
        options7.add(new Option("A. Sự kiện bảo hiểm xảy ra không thuộc phạm vi trách nhiệm bảo hiểm theo thỏa thuận trong hợp đồng bảo hiểm (A).", "0"));
        options7.add(new Option("B. Sự kiện bảo hiểm xảy ra thuộc các trường hợp loại trừ trách nhiệm bảo hiểm theo thỏa thuận trong hợp đồng bảo hiểm (B).", "0"));
        options7.add(new Option("C. Sự kiện bảo hiểm xảy ra trong thời gian gia hạn nộp phí bảo hiểm.", "0"));
        options7.add(new Option("D. A, B đúng.", "100"));
        q7.setOptions(options7);
        questions.add(q7);
        Question q8 = new Question("Đối với hợp đồng bảo hiểm con người, trường hợp một hoặc một số người thụ hưởng cố ý gây ra cái chết hoặc thương tật vĩnh viễn cho người được bảo hiểm thì:");
        List<Option> options8 = new ArrayList<>();
        options8.add(new Option("Doanh nghiệp bảo hiểm không phải trả tiền bảo hiểm.", "0"));
        options8.add(new Option("Doanh nghiệp bảo hiểm vẫn trả tiền cho tất cả người thụ hưởng bảo hiểm.", "0"));
        options8.add(new Option("C. Doanh nghiệp bảo hiểm vẫn phải trả tiền bảo hiểm cho những người thụ hưởng khác theo thoả thuận trong hợp đồng bảo hiểm.", "100"));
        options8.add(new Option("D. Không trường hợp nào đúng.", "0"));
        q8.setOptions(options8);
        questions.add(q8);
        Question q9 = new Question("Doanh nghiệp bảo hiểm có nghĩa vụ:");
        List<Option> options9 = new ArrayList<>();
        options9.add(new Option("A. Chi trả tất cả các chi phí khai thác hợp đồng bảo hiểm cho đại lý ngoài hoa hồng bảo hiểm (A).", "0"));
        options9.add(new Option("B. Yêu cầu đại lý bảo hiểm phải có tài sản thế chấp.", "0"));
        options9.add(new Option("C. Chịu trách nhiệm về những thiệt hại hay tổn thất do hoạt động đại lý bảo hiểm của mình gây ra theo thỏa thuận trong hợp đồng đại lý bảo hiểm (C).", "100"));
        options9.add(new Option("D. A, C đúng.", "0"));
        q9.setOptions(options9);
        questions.add(q9);
        Question q10 = new Question("Trong Sản phẩm Bảo hiểm Ung Thư 360, quyền lợi nào sau đây sẽ chấm dứt ngay khi Manulife chấp nhận chi trả:");
        List<Option> options10 = new ArrayList<>();
        options10.add(new Option("A. Quyền lợi bảo hiểm Ung Thư Giai Đoạn Cuối", "0"));
        options10.add(new Option("B. Quyền lợi bảo hiểm Ung Thư Chi Phí Lớn", "0"));
        options10.add(new Option("C. Quyền lợi bảo hiểm Miễn Đóng Phí", "0"));
        options10.add(new Option("D. Cả ba đáp án A, B và C.", "100"));
        q10.setOptions(options10);
        questions.add(q10);
        Category defaultCate = ExamApplication.getDefaultCategory();
        for (Question q: questions) {
            defaultCate.addQuestion(q);
        }
        ExamApplication.SaveData();
    }
}
