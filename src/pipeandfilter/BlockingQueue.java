package pipeandfilter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class BlockingQueue extends Pipe {
   
 Queue<String> _inData = new LinkedList<String>();
 
 public synchronized  void dataIN (String in){
     _inData.add(in);
     notify(); 
 }
     
 public synchronized String dataOUT (){
	 if(_inData.isEmpty())
		try {
			wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      return _inData.poll();
 }
	 
}
	
	
