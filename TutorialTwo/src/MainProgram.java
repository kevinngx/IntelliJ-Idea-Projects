public class MainProgram {


    public static void main(String[] args) throws InterruptedException{
        //Timestamp of when it starts
        long startTime = System.currentTimeMillis();
        //How long you want the code to run for in milliseconds, this is 5 seconds
        long maxLengthTime = 1000 * 5;
        //Write the 3 lines to create the thread
        Thread threadOne = new Thread (new MessageLoop("File1.txt", 200));
        Thread threadTwo = new Thread (new MessageLoop("File2.txt", 100));
        Thread threadRecord = new Thread(new Recorder());
        //Write the 3 lines to start the thread
        threadOne.start();
        threadTwo.start();
        threadRecord.start();


        //You don't need to touch this, you ask your tutor if you want extra help
        while(threadOne.isAlive()|| threadTwo.isAlive()){
            if ((System.currentTimeMillis() - startTime) > maxLengthTime){
                if( threadOne.isAlive()){
                    threadOne.interrupt();
                    //Waits for threadone to exit and then Main Program continues
                    threadOne.join();
                } else if (threadTwo.isAlive()){
                    threadTwo.interrupt();
                    threadTwo.join();
                }

            }
        }
        threadRecord.interrupt();
        threadRecord.join();


    }



}





