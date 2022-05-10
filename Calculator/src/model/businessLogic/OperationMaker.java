package model.businessLogic;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class OperationMaker {

    private ScriptEngineManager mgr;
    private ScriptEngine engine;
    
    
	public OperationMaker(ScriptEngineManager mgr, ScriptEngine engine) {
		this.mgr = mgr;
		this.engine = engine;
	}
	
	public OperationMaker(String engine) {
		this.mgr = new ScriptEngineManager();
		this.engine = mgr.getEngineByName(engine);
	}
	
	public OperationMaker() {
		this.mgr = new ScriptEngineManager();
		this.engine = mgr.getEngineByName("graal.js");
	}
	
	public ScriptEngineManager getMgr() {
		return mgr;
	}
	public void setMgr(ScriptEngineManager mgr) {
		this.mgr = mgr;
	}
	public ScriptEngine getEngine() {
		return engine;
	}
	public void setEngine(ScriptEngine engine) {
		this.engine = engine;
	}
	
	public String makeOperation(String operation) throws ScriptException{
		return this.engine.eval(operation).toString();
	}
	
}
