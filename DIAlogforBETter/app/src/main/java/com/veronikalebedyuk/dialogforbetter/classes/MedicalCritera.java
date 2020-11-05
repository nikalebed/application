package com.veronikalebedyuk.dialogforbetter.classes;

public class MedicalCritera {
    public MedicalCritera(String name, double standart, double standartDelta, double criticalLow, double criticalHigh) {
        this.name = name;
        this.standart = standart;
        this.standartDelta = standartDelta;
        this.criticalLow = criticalLow;
        this.criticalHigh = criticalHigh;
    }
    MedicalCritera(){}

    private String name;

    public String getName() {
        return name;
    }

    public double getStandart() {
        return standart;
    }

    public double getStandartDelta() {
        return standartDelta;
    }

    public double getCriticalLow() {
        return criticalLow;
    }

    public double getCriticalHigh() {
        return criticalHigh;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStandart(double standart) {
        this.standart = standart;
    }

    public void setStandartDelta(double standartDelta) {
        this.standartDelta = standartDelta;
    }

    public void setCriticalLow(double criticalLow) {
        this.criticalLow = criticalLow;
    }

    public void setCriticalHigh(double criticalHigh) {
        this.criticalHigh = criticalHigh;
    }

    private double standart;
    private double standartDelta;
    private double criticalLow;
    private double criticalHigh;

    public String Estimate(double d){
        if(d>=criticalHigh)return"показатель значительно привышает норму, хотите назначить визит к врачу?";
        if(d<=criticalLow)return"показатель значительно ниже нормы, хотите назначить визит к врачу?";
        else if (d< standart-standartDelta)return"показатель ниже нормы";
        else if (d> standart+standartDelta)return"показатель выше нормы";
        else return "значение показателя в норме";
    }
    public String InputRequest(){
        if(name.equals("сахар"))return "введите число - уровень сахара в крови";
        if(name.equals("систолическое давление"))return "введите число - уровень давления крови в момент максимального сокращения сердца";
        if(name.equals("диастолическое давление"))return "введите число - уровень давления крови в момент максимального расслабления сердца";
        if(name.equals("холестерин"))return "введите число - общий уровень холестерина в крови ммоль/л";
        if(name.equals("вес"))return "введите число - ваш вес в кг";
        if(name.equals("острота зрения"))return "введите число - показатель остроты зрения";
        return "";
    }
}
