public class Main {

    public static void main(String[] args) throws InterruptedException {

        Thread threadOne = new Thread(new MessageLoop("File1.txt", 200));
        Thread threadTwo = new Thread(new MessageLoop("File2.txt", 100));
        Thread recorder = new Thread(new Recorder());

        threadOne.start();
        threadTwo.start();
        recorder.start();

        long startTime = System.currentTimeMillis();
        long maxLengthTime = 1000 * 5; // 5 seconds


        while (threadOne.isAlive() || threadTwo.isAlive()) {
            if (System.currentTimeMillis() - startTime > maxLengthTime) {
                if (threadOne.isAlive()) {
                    threadOne.interrupt();
                    threadOne.join();
                } else if (threadTwo.isAlive()) {
                    threadTwo.interrupt();
                    threadTwo.join();
                }
            }
        }

//        while(threadOne.isAlive()|| threadTwo.isAlive()){
//            if ((System.currentTimeMillis() - startTime) > maxLengthTime){
//                if( threadOne.isAlive()){
//                    threadOne.interrupt();
//                    //Waits for threadone to exit and then Main Program continues
//                    threadOne.join();
//                } else if (threadTwo.isAlive()){
//                    threadTwo.interrupt();
//                    threadTwo.join();
//                }
//
//            }
//        }



        recorder.interrupt();
        recorder.join();

    }
}
