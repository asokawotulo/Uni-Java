package poke;

public class Squirtle extends Pokemon{
    private String base_name = "Squirtle";
    private String base_type = "Water";
    private int base_hp_max = 50;
    private int base_hp_current = 50;
    private int base_level = 5;
    private int base_atk = 30;
    private int base_def = 30;

    public Squirtle(){
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
