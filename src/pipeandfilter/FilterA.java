package pipeandfilter;

import java.util.Scanner;

public  class FilterA extends Filter {
 
    public FilterA(Pipe _dataINPipe, Pipe _dataOUTPipe) {
		super();
		this._dataINPipe = _dataINPipe;
		this._dataOUTPipe = _dataOUTPipe;
	}

	Pipe _dataINPipe;
    Pipe _dataOUTPipe;
     
    public String getData(){
        return _dataINPipe.dataOUT();
    }
     
    public void sendData( String tempData){
        _dataOUTPipe.dataIN(tempData);
    }

	@Override
	public void run() {
		// TODO Auto-generated method stub
		execute();
	}

	@Override
	protected synchronized void execute() {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		System.out.println("enter operation");

		String s=sc.next();

		_dataOUTPipe.dataIN(s);

		System.out.println("enter operande1");

		String s1=sc.next();

		_dataOUTPipe.dataIN(s1);

		System.out.println("enter operande2");

		String s2=sc.next();

		_dataOUTPipe.dataIN(s2);

	}
}
 