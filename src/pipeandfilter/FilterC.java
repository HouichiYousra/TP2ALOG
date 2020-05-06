package pipeandfilter;
public  class FilterC extends Filter {
 
    Pipe _dataINPipe;
    Pipe _dataOUTPipe;
     
    public FilterC(Pipe _dataINPipe, Pipe _dataOUTPipe) {
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
	@Override
	synchronized void execute() {
		// TODO Auto-generated method stub
		String op = getData();
		System.out.println("operation"+ op );
		switch (op){
			case "!":
				System.out.println("operande1"+getData());
				System.out.println("resultat"+getData());
				break;
			case "+":
			case "*":
				System.out.println("operande1"+getData());
				System.out.println("operande2"+getData());
				System.out.println("resultat"+getData());
				break;
		}

	}
}
 