public class SchoolListBatch {

    SchoolList []schoolListBatch;


    int index=0;
    public SchoolListBatch(){
        schoolListBatch=new SchoolList[0];


    }


    public void addSchoolList(SchoolList schoolList){

        schoolListBatch=replace_old_arr();
        schoolListBatch[index++]=schoolList;

    }


    public void removeSchoolList(String yearBatch,String school_name){
        for (int i=0;i<index;i++){
            if(yearBatch.equals(getSchoolList()[i].getYearBatch())){
                for(School s:getSchoolList()[i].getSchools()){
                    if(school_name.equals(s.getSchool_name())){
                        schoolListBatch[i].removeSchool(school_name);

                    }
                }
            }
        }

    }
    public SchoolList[] getSchoolList(){
        return this.schoolListBatch;}

    public boolean findyearBatch(String yearBatch,String school_name){
        boolean find=false;
        for (int i=0;i<index;i++){
            if(yearBatch.equals(getSchoolList()[i].getYearBatch())){
                int j =0;
                for(School s:getSchoolList()[i].getSchools()){

                    if(school_name.equals(s.getSchool_name())){
                        find=true;

                        break;


                        }
                    }
                }
            }
        return find;
        }



    public void foundyearBatch(String yearBatch,String school_name){
        for (int i=0;i<index;i++){
            if(yearBatch.equals(getSchoolList()[i].getYearBatch())){
                for(School s:getSchoolList()[i].getSchools()){
                    if(school_name.equals(s.getSchool_name())){
                        for(Mark m: s.getMarkList().getMarks()) {
                            System.out.println("Student ID:" + m.getID()+" Score:"+m.getScrore());


                        }
                    }
                }
            }
        }
    }




    private SchoolList[] replace_old_arr(){
        SchoolList []new_arr=new SchoolList[index+1];
        int k=0;
        for(SchoolList s:schoolListBatch){
            new_arr[k]=s;
            k++;
        }
        return new_arr;

    }




}
