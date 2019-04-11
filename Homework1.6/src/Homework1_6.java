public class Homework1_6 {
    public static void main(String args[]){
        for ( int i=100 ; i<1000 ; i++ ){
            int g=i%10 , s=(i/10)%10 , b=i/100;
            if ( (g*g*g+s*s*s+b*b*b)==i ){
                System.out.println(i);
            }
        }
    }
}