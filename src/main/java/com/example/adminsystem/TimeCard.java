package com.example.adminsystem;

import javafx.beans.property.SimpleStringProperty;

public class TimeCard
{
    private SimpleStringProperty timeCardId;
    private SimpleStringProperty timeCardFName;
    private SimpleStringProperty timecardLName;
    private SimpleStringProperty timecardPosition;
    private SimpleStringProperty punchIn;
    private SimpleStringProperty punchOut;
    private SimpleStringProperty startMeal;
    private SimpleStringProperty endMeal;
    private SimpleStringProperty timecardDate;

    public TimeCard(String timeCardId,String timeCardFName,String timecardLName,String timecardPosition,String punchIn,String punchOut,String startMeal,String endMeal,String timecardDate)
    {
        this.timeCardId = new SimpleStringProperty(timeCardId);
        this.timeCardFName = new SimpleStringProperty(timeCardFName);
        this.timecardLName= new SimpleStringProperty(timecardLName);
        this.timecardPosition= new SimpleStringProperty(timecardPosition);
        this.punchIn = new SimpleStringProperty(punchIn);
        this.punchOut = new SimpleStringProperty(punchOut);
        this.startMeal = new SimpleStringProperty(startMeal);
        this.endMeal = new SimpleStringProperty(endMeal);
        this.timecardDate = new SimpleStringProperty(timecardDate);
    }

    public String getTimeCardId() {
        return timeCardId.get();
    }

    public SimpleStringProperty timeCardIdProperty() {
        return timeCardId;
    }

    public void setTimeCardId(String timeCardId) {
        this.timeCardId.set(timeCardId);
    }

    public String getTimeCardFName() {
        return timeCardFName.get();
    }

    public SimpleStringProperty timeCardFNameProperty() {
        return timeCardFName;
    }

    public void setTimeCardFName(String timeCardFName) {
        this.timeCardFName.set(timeCardFName);
    }

    public String getTimecardLName() {
        return timecardLName.get();
    }

    public SimpleStringProperty timecardLNameProperty() {
        return timecardLName;
    }

    public void setTimecardLName(String timecardLName) {
        this.timecardLName.set(timecardLName);
    }

    public String getPunchIn() {
        return punchIn.get();
    }

    public SimpleStringProperty punchInProperty() {
        return punchIn;
    }

    public void setPunchIn(String punchIn) {
        this.punchIn.set(punchIn);
    }

    public String getPunchOut() {
        return punchOut.get();
    }

    public SimpleStringProperty punchOutProperty() {
        return punchOut;
    }

    public void setPunchOut(String punchOut) {
        this.punchOut.set(punchOut);
    }

    public String getStartMeal() {
        return startMeal.get();
    }

    public SimpleStringProperty startMealProperty() {
        return startMeal;
    }

    public void setStartMeal(String startMeal) {
        this.startMeal.set(startMeal);
    }

    public String getEndMeal() {
        return endMeal.get();
    }

    public SimpleStringProperty endMealProperty() {
        return endMeal;
    }

    public void setEndMeal(String endMeal) {
        this.endMeal.set(endMeal);
    }

    public String getTimecardDate() {
        return timecardDate.get();
    }

    public SimpleStringProperty timecardDateProperty() {
        return timecardDate;
    }

    public void setTimecardDate(String timecardDate) {
        this.timecardDate.set(timecardDate);
    }

    public String getTimecardPosition() {
        return timecardPosition.get();
    }

    public SimpleStringProperty timecardPositionProperty() {
        return timecardPosition;
    }

    public void setTimecardPosition(String timecardPosition) {
        this.timecardPosition.set(timecardPosition);
    }
}
