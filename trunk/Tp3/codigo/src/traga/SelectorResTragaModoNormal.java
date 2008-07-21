package traga;

public class SelectorResTragaModoNormal implements ISelectorResTraga {

	private static SelectorResTragaModoNormal instance;

	private SelectorResTragaModoNormal(){
	}

	public static SelectorResTragaModoNormal getInstance(){
		if(instance != null)
			instance = new SelectorResTragaModoNormal();
		return instance;
	}

	public ResultTraga getResult(){
		return null;
	}

}