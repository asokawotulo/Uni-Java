package poke;

public class Charmander extends Pokemon{
    private String base_name = "Charmander";
    private String base_type = "Fire";
    private int base_hp_max = 30;
    private int base_hp_current = 30;
    private int base_level = 5;
    private int base_atk = 50;
    private int base_def = 35;

    public Charmander(){
        super.setName(base_name);
        super.setType(base_type);
        super.setHp_max(base_hp_max);
        super.setHp_current(base_hp_current);
        super.setLevel(base_level);
        super.setAtk(base_atk);
        super.setDef(base_def);
        
        super.setBaseStat(base_hp_max, base_atk, base_def);
    }
}
