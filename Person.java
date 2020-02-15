
public class Person {
    String id;
    String name;
    String isMale;
    String isLightSkin;
    String isBald;
    String hasFacialHair;
    String hasBlueEyes;
    String isWearingHat;
    String isWearingGlasses;
    String hasBlackHair;

    @Override
    public String toString() {
        return "Person [" +
                "" + name +
                ",is male= " + isMale +
                ",is light skin= " + isLightSkin +
                ", is bald= " + isBald +
                ",has facial hair= " + hasFacialHair +
                ",has blue eyes= " + hasBlueEyes +
                ",is wearing hat= " + isWearingHat +
                ",is wearing glasses= " + isWearingGlasses +
                ",has black hair= " + hasBlackHair + "]";
    }

    public String getAtrribute(String attr){
        switch(attr){
            case "isMale":
                return this.getIsMale();
            case "isLightSkin":
                return this.getIsLightSkin();
            case "isBald":
                return this.getIsBald();
            case "hasFacialHair":
                return this.getHasFacialHair();
            case "hasBlueEyes":
                return this.getHasBlueEyes();
            case "isWearingHat":
                return this.getIsWearingHat();
            case "isWearingGlasses":
                return this.getIsWearingGlasses();
            case "hasBlackHair":
                return this.getHasBlackHair();
            default:
                return "";
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsMale() {
        return isMale;
    }

    public void setIsMale(String isMale) {
        this.isMale = isMale;
    }

    public String getIsLightSkin() {
        return isLightSkin;
    }

    public void setIsLightSkin(String isLightSkin) {
        this.isLightSkin = isLightSkin;
    }

    public String getIsBald() {
        return isBald;
    }

    public void setIsBald(String isBald) {
        this.isBald = isBald;
    }

    public String getHasFacialHair() {
        return hasFacialHair;
    }

    public void setHasFacialHair(String hasFacialHair) {
        this.hasFacialHair = hasFacialHair;
    }

    public String getHasBlueEyes() {
        return hasBlueEyes;
    }

    public void setHasBlueEyes(String hasBlueEyes) {
        this.hasBlueEyes = hasBlueEyes;
    }

    public String getIsWearingHat() {
        return isWearingHat;
    }

    public void setIsWearingHat(String isWearingHat) {
        this.isWearingHat = isWearingHat;
    }

    public String getIsWearingGlasses() {
        return isWearingGlasses;
    }

    public void setIsWearingGlasses(String isWearingGlasses) {
        this.isWearingGlasses = isWearingGlasses;
    }

    public String getHasBlackHair() {
        return hasBlackHair;
    }

    public void setHasBlackHair(String hasBlackHair) {
        this.hasBlackHair = hasBlackHair;
    }
}
