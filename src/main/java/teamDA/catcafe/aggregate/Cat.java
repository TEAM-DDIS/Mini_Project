package teamDA.catcafe.aggregate;

import java.io.Serializable;

public class Cat implements Serializable {
    private int catNo;
    private String name;
    private String breeds;
    private Gender gender;
    private String regDate;
    private CatStatus catStatus;
    private boolean isNeutered;

    public Cat() {
    }

    public Cat(String name, String breeds, Gender gender, boolean isNeutered) {
        this.name = name;
        this.breeds = breeds;
        this.gender = gender;
        this.isNeutered = isNeutered;
    }

    public Cat(int catNo, String name, String breeds, Gender gender, String regDate, CatStatus catStatus, boolean isNeutered) {
        this.catNo = catNo;
        this.name = name;
        this.breeds = breeds;
        this.gender = gender;
        this.regDate = regDate;
        this.catStatus = catStatus;
        this.isNeutered = isNeutered;
    }

    public int getCatNo() {
        return catNo;
    }

    public void setCatNo(int catNo) {
        this.catNo = catNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreeds() {
        return breeds;
    }

    public void setBreeds(String breeds) {
        this.breeds = breeds;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public CatStatus getCatStatus() {
        return catStatus;
    }

    public void setCatStatus(CatStatus catStatus) {
        this.catStatus = catStatus;
    }

    public boolean isNeutered() {
        return isNeutered;
    }

    public void setNeutered(boolean neutered) {
        isNeutered = neutered;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "catNo=" + catNo +
                ", name='" + name + '\'' +
                ", breeds='" + breeds + '\'' +
                ", gender=" + gender +
                ", regDate=" + regDate +
                ", catStatus=" + catStatus +
                ", isNeutered=" + isNeutered +
                '}';
    }
}
