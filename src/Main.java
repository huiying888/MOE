import java.util.Scanner;

public class Main {

    /*
     In order to be included in a national ranking exercise,
     secondary schools may choose to participate in a math competency
     evaluation survey.
     The MoE maintains the list of the schools (there may new addition,
     and some schools may opt out).
     Each school is identified by the name,
     the address (this usually split into multiple parts),
     the principal's name (first name, last name).
      A dataset of marks collected for each school.
      Each marks entry consists of a score,
      the ID and name and class name of the participating student.
      The survey is carried out on a yearly basis.




     */
    static SchoolListBatch schoolListsBatch;
    static SchoolList schoolList;
    static MarkList markList;


    static int num_school=0;
    static int num_stu=0;
    static Scanner in=new Scanner(System.in);
    public static void main(String[] args) {
        schoolListsBatch=new SchoolListBatch();
       String decision_year="Y";
       do{
           System.out.println("Enter the year of batch: ");
           String year=in.next();

           System.out.println("How many schools you wanna add: ");
           num_school=in.nextInt();
           schoolList=new SchoolList(num_school,year);
           for (int j=0;j<num_school;j++){
               System.out.println("School # "+(j+1));
               System.out.println("Enter the name of the school : ");
               String school_mname = in.next();

               System.out.println("Enter the first name of principal : ");
               String prin_fname = in.next();
               System.out.println("Enter the middle name of principal : ");
               String prin_mname = in.next();
               System.out.println("Enter the last name of principal : ");
               String prin_lname = in.next();

               PrincipalName principalName=new PrincipalName(prin_fname,prin_mname,prin_lname);

               System.out.println("Enter the unitno of the school : ");
               String school_unitno = in.next();
               System.out.println("Enter the street of the school : ");
               String school_street = in.next();

               Address address=new Address(school_unitno,school_street);

               System.out.println("How many students you wanna add: ");
               num_stu=in.nextInt();
               markList=new MarkList(num_stu);
               for(int i=0;i<num_stu;i++) {
                   System.out.println("Student # "+(i+1));
                   System.out.println("Enter the name of student : ");
                   String stu_name = in.next();

                   System.out.println("Enter the ID of student : ");
                   String id = in.next();

                   System.out.println("Enter the class name of student : ");
                   String class_name = in.next();

                   System.out.println("Enter the mark of student : ");
                   float score = in.nextFloat();

                   Mark mark_stu = new Mark(stu_name, id, score, class_name);
                   markList.addMark(mark_stu);

           }



               School school=new School(school_mname,principalName,address,markList);
               schoolList.addSchool(school);



           }

           schoolListsBatch.addSchoolList(schoolList);

           System.out.println("Do you want to continue adding the year of batch?(Y/N):  ");
           decision_year= in.next();
       }while (decision_year.equals("Y"));






       for(SchoolList sl:schoolListsBatch.getSchoolList()){
           System.out.println("Year of batch: "+ sl.getYearBatch()+"\n");
           int k = 1;
           for(School s:sl.getSchools()) {

               System.out.println("School# " + (k++));
               System.out.println("School Name: " + s.getSchool_name());
               System.out.println("School Address: " + s.getAddress().getAddress());
               System.out.println("Principal Name: " + s.getprincipalName().getFullName()+"\n");
               int q = 0;
               for (Mark m : s.getMarkList().marks) {
                   System.out.println("Student Name:" + m.getName());
                   System.out.println("Student ID:" + m.getID());
                   System.out.println("Student Score:" + m.getScrore());
                   System.out.println("Student Class Name:" + m.getClass_name()+"\n");
                   q++;
               }
               System.out.println("Sorted Mark: ");
               s.getMarkList().sortList(q);
               for (Mark m : s.getMarkList().marks) {
                   System.out.println("Student ID:" + m.getID() + " Score:" + m.getScrore());


               }
               System.out.println("Average Mark: " + s.getMarkList().getAvg(q));
               System.out.println("Standard Deviation Mark: " + s.getMarkList().getSD(q)+"\n");


           }
       }
       String to_find;
        System.out.println("Do you want to find any school records?(Y/N)");
        to_find=in.next();
       while(to_find.equals("Y")) {
           System.out.println("Enter the the year of batch: ");
           String year=in.next();
           System.out.println("Enter the name of school: ");
           String sn=in.next();
           boolean find=schoolListsBatch.findyearBatch(year,sn);
           if(find){
               schoolListsBatch.foundyearBatch(year,sn);
           }
           else{
               System.out.println("Not found");
           }

           System.out.println("Do you want to find any school records?(Y/N)");
           to_find=in.next();


       }

        String to_remove="Y";
        System.out.println("Do you want to remove your school records?(Y/N)");
        to_remove=in.next();
        while(to_remove.equals("Y")) {
            System.out.println("Enter the the year of batch: ");
            String year_remove=in.next();
            System.out.println("Enter the name of school: ");
            String sn_remove=in.next();

            boolean find=schoolListsBatch.findyearBatch(year_remove,sn_remove);
            if(find){
                schoolListsBatch.removeSchoolList(year_remove,sn_remove);
            }
            else{
                System.out.println("Not found");
            }

            System.out.println("Do you want to remove your school records?(Y/N)");
            to_remove=in.next();


        }



        for(SchoolList sl:schoolListsBatch.getSchoolList()){
            System.out.println("Year of batch: "+ sl.getYearBatch()+"\n");
            int k = 0;
            for(School s:sl.getSchools()) {

                System.out.println("School# " + (++k));
                System.out.println("School Name: " + s.getSchool_name());
                System.out.println("School Address: " + s.getAddress().getAddress());
                System.out.println("Principal Name: " + s.getprincipalName().getFullName()+"\n");
                int q = 0;
                for (Mark m : s.getMarkList().marks) {
                    System.out.println("Student Name:" + m.getName());
                    System.out.println("Student ID:" + m.getID());
                    System.out.println("Student Score:" + m.getScrore());
                    System.out.println("Student Class Name:" + m.getClass_name()+"\n");
                    q++;
                }
                System.out.println("Sorted Mark: ");
                s.getMarkList().sortList(q);
                for (Mark m : s.getMarkList().marks) {
                    System.out.println("Student ID:" + m.getID() + " Score:" + m.getScrore());


                }
                System.out.println("Average Mark: " + s.getMarkList().getAvg(q));
                System.out.println("Standard Deviation Mark: " + s.getMarkList().getSD(q)+"\n");


            }
        }
    }
}