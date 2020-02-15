public class Question {

    public Question(String questionText, String attributeId) {
        this.questionText = questionText;
        this.attributeId= attributeId;
    }

    public String getQuestionText() {
        return questionText;
    }

    public String getAttributeId() {
        return attributeId;
    }

    private String questionText;
    private String attributeId;
}
