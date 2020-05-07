package pipeandfilter;

import Trace.Trace;

public  class Calcul extends Filter {
 
    Pipe _dataINPipe;
    Pipe _dataOUTPipe;
    
    public Calcul(Pipe _dataINPipe, Pipe _dataOUTPipe) {
		super();
		this._dataINPipe = _dataINPipe;
		this._dataOUTPipe = _dataOUTPipe;
	}
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

	private int fact (int a){
		int i,fact=1;
		for(i=1;i<=a;i++){
			fact=fact*i;
		}
		return fact;
	}

	@Override
	protected synchronized void execute() {
		// TODO Auto-generated method stub

		while (true){
			String operation = getData();
			String[] parts = operation.split("-");

		switch(parts[0]){
			case "+":
				System.out.println("suuum");
				int resultat = Integer.parseInt(parts[1])+Integer.parseInt(parts[2]);
				sendData("+-"+parts[1] +"-"+parts[2]+"-"+Integer.toString(resultat));
				break;
			case "*":
				System.out.println("multii");
				int resultat1 = Integer.parseInt(parts[1])*Integer.parseInt(parts[2]);
				sendData("*-"+parts[1] +"-"+parts[2]+"-"+Integer.toString(resultat1));
				break;
			case "!":
				System.out.println("factoo");
				int result = fact(Integer.parseInt(parts[1]));
				sendData("!-"+parts[1] +"-"+parts[2]+"-"+Integer.toString(result));
				break;
		}


	}}


	}


 