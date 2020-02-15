//Laldhan Tamang

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class GuessWho {

    public static void main(String[] args) throws IOException {
        GuessWho person = new GuessWho();
        person.play();
    }

    public void play() throws IOException {

        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to Guess Who Game!");
        System.out.println("Are you a player or an admin?");
        String user = input.next();

        if (user.equals("player")) {
            System.out.println("Instruction !");
            System.out.println("HOST ANNOUNCEMENT");
            List<Person> personListForPlayer = loadPersons("C:\\Users\\laldh\\Desktop\\Fall 2019\\Java\\GuessWho\\People1.csv");
            List<Person> personListForComputer = loadPersons("C:\\Users\\laldh\\Desktop\\Fall 2019\\Java\\GuessWho\\People1.csv");

            List<Question> playerQuestions = getQuestionsList();
            List<Question> computerQuestions = getQuestionsList();

            Person playerSelectedPerson, computerSelectedPerson;

            for (int i = 0; i < personListForPlayer.size(); i++) {
                System.out.println(i + " . " + personListForPlayer.get(i));
            }
            System.out.println("");
            System.out.println("Please pick a person from the list above. ");
            System.out.println("Please pick a number");

            int playerSelectedPersonNumber = input.nextInt();//person choosen by the player from the question list
            playerSelectedPerson = personListForPlayer.get(playerSelectedPersonNumber);
            System.out.println("You selected : " + playerSelectedPerson);

            int computerSelectedPersonNumber = getRandomNumber(23, 0);
            computerSelectedPerson = personListForComputer.get(computerSelectedPersonNumber);

            //System.out.println("COMPUTER SELECTED PERSON" + computerSelectedPerson.getName());
            System.out.println("HOST ANNOUNCEMENT");
            System.out.println("Computer has also selected one person!!!");

            while (true) {
                if (personListForComputer.size() == 1 || personListForPlayer.size() == 1)
                    break;

                System.out.println("Here is a list of questions you can ask");
                displayQuestionList(playerQuestions);//Displays 7 questions
                System.out.println("HOST ANNOUNCEMENT");
                System.out.println("Player, Please pick your question number.");
                int questionNumber1 = input.nextInt();//First question from the player

                Question playerAskedQuestion = playerQuestions.remove(questionNumber1);
                //this question needs to be removed from questions list so that it doesn't appear on the list next time

                String computerAnswer = computerSelectedPerson.getAtrribute(playerAskedQuestion.getAttributeId());
                System.out.println("computerAnswer = " + computerAnswer);
                //we need to filter our person list based on computer answer

                personListForPlayer = filterPersonList(personListForPlayer, playerAskedQuestion, computerAnswer);
                personListForPlayer.forEach(a -> System.out.println("a = " + a));//filtered list

                //computer needs to select a question and ask us
                System.out.println("HOST ANNOUNCEMENT......... Computer turn to ask question");
                Question questionFromComputer = getQuestionFromComputerToPlayer(computerQuestions);
                computerQuestions.remove(0);
                System.out.println("Computer says: ");
                System.out.println(questionFromComputer.getQuestionText());

                String playerAnswer = input.next();

                personListForComputer = filterPersonList(personListForComputer, questionFromComputer, playerAnswer);
                //for further development:
                //Computer filters Person list based on players answer
            }
            if (personListForPlayer.size() == 1) {
                decideWinner(personListForPlayer, computerSelectedPerson, "Player");
            } else if (personListForComputer.size() == 1) {
                decideWinner(personListForComputer, playerSelectedPerson, "Computer");

            }

        } else if (user.equals("admin")) {
            System.out.print("Enter Password>>");
            String password = input.next();
            if (password.equals("Password"))
                System.out.println("HOST ANNOUNCEMENT:  ");
            System.out.println("Welcome to admin page.");
            System.out.println("To view person list enter VIEW.");
            System.out.println("To edit person list enter EDIT");

            String adminSelected = input.next();
            if (adminSelected.equals("VIEW")) {
                List<Person> personList = loadPersons("C:\\Users\\laldh\\Desktop\\Fall 2019\\Java\\GuessWho\\People1.csv");
                for (int i = 0; i < personList.size(); i++) {
                    System.out.println(i + " . " + personList.get(i));
                }
            } else if (adminSelected.equals("EDIT")) {
                System.out.println("HOST ANNOUNCEMENT");
                System.out.println("Sorry function not available!");
                System.out.println("Please come back later to use this function!");
            }
        }

    }

    private List<Person> filterPersonList(List<Person> people, Question question, String answer) {
        List<Person> filteredPersonList = new ArrayList<>();
        for (int i = 0; i < people.size(); i++) {
            Person p = people.get(i);
            String actualAnswer = p.getAtrribute(question.getAttributeId());
            if (answer.equals(actualAnswer)) {
                filteredPersonList.add(p);
            }
        }
        return filteredPersonList;
    }


    public List<Person> loadPersons(String filePath) throws IOException {

        List<Person> persons = new ArrayList();

        BufferedReader csvReader = new BufferedReader(new FileReader(filePath));
        String row;
        while ((row = csvReader.readLine()) != null) {
            String[] data = row.split(",");
            // do something with the data
            //System.out.println(Arrays.toString(data));
            Person p = new Person();
            p.setId(data[0]);
            p.setName(data[1]);
            p.setIsMale(data[2]);
            p.setIsLightSkin(data[3]);
            p.setIsBald(data[4]);
            p.setHasFacialHair(data[5]);
            p.setHasBlueEyes(data[6]);
            p.setIsWearingHat(data[7]);
            p.setIsWearingGlasses(data[8]);
            p.setHasBlackHair(data[9]);
            persons.add(p);

        }
        csvReader.close();
        return persons;
    }


    public List<Question> getQuestionsList() {
        List<Question> questions = new ArrayList<>();

        questions.add(new Question("Is the person male?", "isMale"));
        questions.add(new Question("Does the person have light skin?", "isLightSkin"));
        questions.add(new Question("Is your person bald?", "isBald"));
        questions.add(new Question("Does your person have facial hair?", "hasFacialHair"));
        questions.add(new Question("Do they have blue eyes?", "hasBlueEyes"));
        questions.add(new Question("Is your person wearing a hat?", "isWearingHat"));
        questions.add(new Question("Is your person wearing glasses?", "isWearingGlasses"));

        return questions;

    }

    public void displayQuestionList(List<Question> questions) {
        for (int i = 0; i < questions.size(); i++) {
            System.out.println(i + ". " + questions.get(i).getQuestionText());
        }
    }

    public int getRandomNumber(int max, int min) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;

    }

    public Question getQuestionFromComputerToPlayer(List<Question> questions) {
        return questions.get(0);
    }

    public void decideWinner(List<Person> personList, Person selectedPerson, String participant) {

        if (personList.size() == 1) {
            System.out.println(participant + " says:");
            Person p = personList.get(0);

            System.out.println("Is " + p.getName() + " your mystery person?");

            System.out.println("Host Says");
            if (selectedPerson.getName().equals(p.getName())) {
                System.out.println("Congratulations !!! " + participant + " Win!!");
            } else {
                System.out.println("OOPS wrong person! Your Opponent Won!!");
            }

        }
    }
}
