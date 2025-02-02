package pipeandfilter;


public abstract class Filter  implements Runnable{
 
    Pipe _dataINPipe;
    Pipe _dataOUTPipe;
     
    public String getData(){
        return _dataINPipe.dataOUT();
    }
     
    public void sendData( String tempData){
        _dataOUTPipe.dataIN(tempData);
    }
    protected abstract void execute();
}
 
