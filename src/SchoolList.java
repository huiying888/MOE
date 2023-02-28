public class SchoolList {
    //get the score for a particular school in a particular year

    School []schools;

    String yearBatch;
    int index_school=0;
    public SchoolList(int num_school,String yearBatch){
        schools=new School[num_school];
        this.yearBatch=yearBatch;
    }

    public School[] getSchools(){
        return this.schools;
    }


    public void addSchool(School school){
        schools[index_school++]=school;
    }

    public void removeSchool(String school_name){

        School[] new_school=new School[schools.length-1];
        int q=0;
        for(School s: schools){

            if (!school_name.equals(s.getSchool_name())){

                new_school[q]=s;

                q++;
            }
        }

        schools=new_school;

    }
    public String getYearBatch(){return this.yearBatch;}
}
