package pipeandfilter;
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
		sendData(operation);
		switch(operation){
			case "+":
				String op1=getData();
				sendData(op1);
				String op2=getData();
				sendData(op2);
				int resultat = Integer.parseInt(op1)+Integer.parseInt(op2);
				sendData(Integer.toString(resultat));
				break;
			case "*":
				String ope1=getData();
				sendData(ope1);
				String ope2=getData();
				sendData(ope2);
				int res = Integer.parseInt(ope1)*Integer.parseInt(ope2);
				sendData(Integer.toString(res));
				break;
			case "!":
				String oper1=getData();
				sendData(oper1);
				int result = fact(Integer.parseInt(oper1));
				sendData(Integer.toString(result));
				break;
		}

	}}
}
 