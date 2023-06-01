package com.example.assignment1;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.paint.Color;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.*;

public class SortingHubController implements Initializable {
    private SortingStrategy sortingMethod;
    public int[] intArray;
    @FXML
    private Slider sliderObject = new Slider();
    @FXML
    private Canvas canvasBars = new Canvas();
    @FXML
    private Button resetBtn;
    @FXML
    private Button sortBtn;
    @FXML
    private Label sliderValue;
    @FXML
    private ComboBox<String> algorithmsComboBox = new ComboBox<>();
    private Random rand = new Random();
    private int[] prevData;


    @FXML
    public void onSliderMoved() {
        //clear canvas when moving the slider
        if (sliderObject.getValue() == sliderObject.getMin() || sliderObject.getValue() == sliderObject.getMax()) {
            // don't shuffle the bars if the slider is at the beginning or end of the slider
            return;
        }
        canvasBars.getGraphicsContext2D().clearRect(0, 0, canvasBars.getWidth(), canvasBars.getHeight());
        DecimalFormat df = new DecimalFormat("0");//format the text in the label
        sliderValue.setText(String.valueOf(df.format(sliderObject.getValue())));
        intArray = new int[(int) sliderObject.getValue()];//array is the same size as slider number
        populateAndShuffle();//repopulate the array again since it gets cleared everytime I move the slider
        updateGraph(intArray);//update graph when slider is moved
    }

    //pick a sorting strategy and sort accordingly to it
    public void executeSort() {
        //disable buttons, slider, and combo box
        sliderObject.setDisable(true);
        resetBtn.setDisable(true);
        sortBtn.setDisable(true);
        algorithmsComboBox.setDisable(true);

        sortingMethod.sort(intArray);//sort the array

        //re-enable after sorting is done
        sliderObject.setDisable(false);
        resetBtn.setDisable(false);
        sortBtn.setDisable(false);
        algorithmsComboBox.setDisable(false);
    }

    @FXML
    public void setSortStrategy() {
        Thread t;//new thread for sorting
        switch (algorithmsComboBox.getValue()) {
            case "Merge Sort":
                sortingMethod = new MergeSort(this);
                t = new Thread(this::executeSort);
                t.start();
                break;
            case "Selection Sort":
                sortingMethod = new SelectionSort(this);
                t = new Thread(this::executeSort);
                t.start();
                break;
            default:
                break;
        }
    }

    @FXML
    public void updateGraph(int[] data) {
        //calc bar width and height
        double barWidth = canvasBars.getWidth() / data.length;
        double barHeight = canvasBars.getHeight() / sliderObject.getValue();

        drawBars(data, barWidth, barHeight);
        drawBorder();
    }

    //method responsible for drawing each bar
    private void drawBars(int[] data, double barWidth, double barHeight) {
        if (prevData == null || prevData.length != data.length) {
            prevData = new int[data.length];//save old data
        }
        double barSpacingSize = 2;//spacing between each bar
        for (int i = 0; i < data.length; i++) {
            double x = i * barWidth;
            double y = canvasBars.getHeight() - barHeight * data[i];
            if (prevData == null || prevData[i] != data[i]) {//check for previously stored data, clear only bars that changed
                canvasBars.getGraphicsContext2D().clearRect(x, 0, barWidth - barSpacingSize, canvasBars.getHeight());
            }
            canvasBars.getGraphicsContext2D().setFill(Color.RED);
            canvasBars.getGraphicsContext2D().fillRect(x, y, barWidth - barSpacingSize, barHeight * data[i]);
            prevData[i] = data[i];
        }
        prevData = Arrays.copyOf(data, data.length);
    }

    private void drawBorder() {
        canvasBars.getGraphicsContext2D().setStroke(Color.BLACK);
        canvasBars.getGraphicsContext2D().setLineWidth(2);
        canvasBars.getGraphicsContext2D().strokeRect(0, 0, canvasBars.getWidth(), canvasBars.getHeight());
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        algorithmsComboBox.getItems().setAll("Merge Sort", "Selection Sort");
        algorithmsComboBox.getSelectionModel().selectFirst();//make first selection appear in the combo box by default

        //make each bar proportional to the canvas width and height
        double barWidth = canvasBars.getWidth() / sliderObject.getValue();
        double barHeight = canvasBars.getHeight() / sliderObject.getValue();
        intArray = new int[(int) sliderObject.getValue()];//array is the same size as slider number
        populateAndShuffle();//populate the array and shuffle it


        //initialize bars
        drawBars(intArray, barWidth, barHeight);
        drawBorder();
    }

    //for the reset button
    @FXML
    public void reset() {
        sliderObject.setValue(64);
        algorithmsComboBox.getSelectionModel().selectFirst();
        canvasBars.getGraphicsContext2D().clearRect(0, 0, canvasBars.getWidth(), canvasBars.getHeight());
        intArray = new int[(int) sliderObject.getValue()];
        DecimalFormat df = new DecimalFormat("0");//format the text in the label
        sliderValue.setText(String.valueOf(df.format(sliderObject.getValue())));
        populateAndShuffle();
        updateGraph(intArray);
    }


    public void populateAndShuffle() {
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = i + 1;//populate array with nums from 1 to slider number
        }
        //randomly shuffle the array
        for (int i = intArray.length - 1; i > 0; i--) {
            int index = rand.nextInt(i + 1);
            int temp = intArray[index];
            intArray[index] = intArray[i];
            intArray[i] = temp;
        }
    }
}