import java.util.ArrayList;
import java.util.Scanner;

class Registration {
  private ArrayList<String> selectedSubjects = new ArrayList<>();
  private ArrayList<String> selectedGroups = new ArrayList<>();
  private ArrayList<String> subjectsAndGroups = new ArrayList<>();

  private String[] subjects = { "Object Oriented Programming", "Logic ", "Linear Algebra", "Discrete Mathematics" };
  private String[][] groups = {
  { "Dr. Ahmed", "Dr. Thamer", "Dr. Majed" },
  { "Dr. Maher", "Dr. Abdullah", "Dr. Mohammed" },
  { "Dr. Fahad", "Dr. Sameer", "Dr. Ali" },
  { "Dr. Khaled", "Dr. Mohanad", "Dr. Hatem" }};
  
  public void register(){ 
  Scanner sc = new Scanner(System.in);
  boolean isRegistrationSubmitted = false;
  while (!isRegistrationSubmitted) {
    if (selectedSubjects.size() == subjects.length) {
      break;
    }
  //printing the menu with number
    System.out.println("Select a subject: ");
    for (int i = 0; i < subjects.length; i++) {
      if (!selectedSubjects.contains(subjects[i])) {
        System.out.println((i + 1) + ". " + subjects[i]);
      }
    }
    //Select the material and confirm the entrance
    int subjectSelection = sc.nextInt();
    while (subjectSelection <= 0 || subjectSelection > 4 || selectedSubjects.contains(subjects[subjectSelection - 1])) {
      System.out.println("Invalid subject selection, please enter a valid number: ");
      subjectSelection = sc.nextInt();
    }
    //Save the user selection in selectedSubject and add it to the arrylist 
     String selectedSubject = subjects[subjectSelection-1];
    selectedSubjects.add(selectedSubject);
    subjectsAndGroups.add(selectedSubject);
    System.out.println("You have selected: " + selectedSubject);
    //Print groups
    System.out.println("Select a group: ");
    for (int i = 0; i < 3; i++) {
      System.out.println((i + 1) + ". Group " + (i + 1) + " with " + groups[subjectSelection - 1][i]);
    }
   //Choose the group and make sure that the entrance is within the limits of the groups
    int groupSelection = sc.nextInt();
    while (groupSelection <= 0 || groupSelection > 3) {
      System.out.println("Invalid group selection, please enter a valid number: ");
      groupSelection = sc.nextInt();
    }
  //Save the user selection in  selectedgrop  and add it to the arrylist 
    String selectedGroup = groups[subjectSelection - 1][groupSelection - 1];
    selectedGroups.add(selectedGroup);
    subjectsAndGroups.add(selectedGroup);
    System.out.println("Current registration: " + selectedSubject + " with " + selectedGroup);
  
    System.out.println("Continue your registration? (yes/no)");
    sc.nextLine();
    String submit = sc.nextLine();

    while (!submit.equalsIgnoreCase("yes") && !submit.equalsIgnoreCase("no")) {
      System.out.println("Invalid Entry, Enter (yes/no)");
      submit = sc.nextLine();
    }
    if (submit.equalsIgnoreCase("No") || selectedSubjects.size() == subjects.length) {
      isRegistrationSubmitted = true;
      System.out.println("Your registration has been submitted for the following subjects and groups:");
      for (int i = 0; i < selectedSubjects.size(); i++) {
          System.out.println(selectedSubjects.get(i)  + ", Doctor: "+ selectedGroups.get(i).substring(0, selectedGroups.get(i).length()));
      }
    }
  }
    sc.close();
}
}