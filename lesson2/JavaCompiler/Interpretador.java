public class Interpretador {
  private ArvoreSintatica arvore_sintatica = null;

  public Interpretador(ArvoreSintatica arv) {
    this.arvore_sintatica = arv;
  }

  public String interpreta() {
    return String.valueOf(this._interpreta(this.arvore_sintatica));
  }
  private Integer _interpreta(ArvoreSintatica arv){
    if (arv instanceof Mult)
		return (_interpreta(((Mult) arv).arg1) * 
			_interpreta(((Mult) arv).arg2));

	if (arv instanceof Soma)
		return (_interpreta(((Soma) arv).arg1) + 
			_interpreta(((Soma) arv).arg2));
	
	if (arv instanceof Sub) 
		return (_interpreta(((Sub) arv).arg1) -
			_interpreta(((Sub) arv).arg2) );

	if (arv instanceof Div) 
		return (_interpreta(((Div) arv).arg1) /
				_interpreta(((Div) arv).arg2));

	if (arv instanceof Num)
		return ((Num) arv).num;

	return 0;
  }
}
