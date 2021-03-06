package ploobs.plantevolution.Gameplay;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Bruno on 11/04/2016.
 */
public class Score
{

    private Map<String,Float> _score = new HashMap<String,Float>();

    private String calcformula;

    public void addParameter(String parname)
    {
        _score.put(parname,0.0f);
    }

    public float getParamValue(String parname)
    {
        float ret=0;

        if (_score.containsKey(parname))
            ret = _score.get(parname);
        else
            ret= 0;

        return ret;
    }


    public void addValuetoParameter(String parname, float v)
    {
        float vv=0;

        if (!_score.containsKey(parname))
            addParameter(parname);

        vv = _score.get(parname);
        vv+=v;
        _score.put(parname,vv);
    }





    public float Execute()
    {
        float retval=0;

       // retval = getParamValue("S")/((getParamValue("M")+1)*(getParamValue("T")+1)*(getParamValue("V")+1) + getParamValue("P") );
        retval = 1000 * (1+getParamValue("Dt"));

        //1000 * (1+Delta(Mmin,Mval) ))

        return retval;

    }


    private Score(){}


    /**
     * SingletonHolder is loaded on the first execution of Singleton.getInstance()
     * or the first access to SingletonHolder.INSTANCE, not before.
     */
    private static class SingletonHolder {
        private static final Score INSTANCE = new Score();
    }

    public static Score getInstance() {
        return SingletonHolder.INSTANCE;
    }




}
