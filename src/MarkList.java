public class MarkList {
    //list out the average score for each schools
    //list out the standard deviation for each schools
    //sort the list
    Mark [] marks;
    int index=0;
    public MarkList(int num){
        marks=new Mark[num];
    }

    public Mark[] getMarks(){
        return this.marks;
    }

    public void addMark(Mark mark){
        marks[index++]=mark;

    }

    public float getAvg(int num){
        float total=0;
        for(int i=0;i<num;i++){
            total+=marks[i].getScrore();


        }
        float avg=total/num;
        return avg;
    }

    public double getSD(int num){
        float total=0;
        for(int i=0;i<num;i++){
            total+=Math.pow((marks[i].getScrore()-getAvg(num)),2);

        }
        double SD=Math.sqrt(total/num);
        return SD;
    }

    public void sortList(int num){
         Mark x;
        for(int i=num;i>0;i--){
            for(int j=0;j<i;j++){
                if(marks[j].getScrore()<marks[i-1].getScrore()){
                    x=marks[i-1];
                    marks[i-1]=marks[j];
                    marks[j]=x;
                }
            }
        }
    }



}
