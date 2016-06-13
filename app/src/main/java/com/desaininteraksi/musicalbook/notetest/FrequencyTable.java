package com.desaininteraksi.musicalbook.notetest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yusfia Hafid A on 4/22/2015.
 */
public class FrequencyTable {
    private ArrayList<NadaDasar> nada;
    private double[][] base =
    {
            {15.42060133 ,31.77219916 ,63.54439833 ,127.0887967 ,254.1775933 ,508.3551866 ,1016.710373 ,2033.420746 ,4066.841493},
            {16.35159783 ,32.70319566 ,65.40639133 ,130.8127827 ,261.6255653 ,523.2511306 ,1046.502261 ,2093.004522 ,4186.009045},
            {16.83073622 ,33.66147244 ,67.32294488 ,134.6458898 ,269.2917795 ,538.5835591 ,1077.167118 ,2154.334236 ,4308.668472},
            {17.32391444 ,34.64782887 ,69.29565774 ,138.5913155 ,277.1826310 ,554.3652620 ,1108.730524 ,2217.461048 ,4434.922096},
            {17.83154388 ,35.66308775 ,71.32617551 ,142.6523510 ,285.3047020 ,570.6094040 ,1141.218808 ,2282.437616 ,4564.875232},
            {18.35404799 ,36.70809599 ,73.41619198 ,146.8323840 ,293.6647679 ,587.3295358 ,1174.659072 ,2349.318143 ,4698.636287},
            {18.89186265 ,37.78372531 ,75.56745061 ,151.1349012 ,302.2698024 ,604.5396049 ,1209.079210 ,2418.158420 ,4836.316839},
            {19.44543648 ,38.89087297 ,77.78174593 ,155.5634919 ,311.1269837 ,622.2539674 ,1244.507935 ,2489.015870 ,4978.031740},
            {20.01523126 ,40.03046253 ,80.06092506 ,160.1218501 ,320.2437002 ,640.4874005 ,1280.974801 ,2561.949602 ,5123.899204},
            {20.60172231 ,41.20344461 ,82.40688923 ,164.8137785 ,329.6275569 ,659.2551138 ,1318.510228 ,2637.020455 ,5274.040911},
            {21.20539885 ,42.41079770 ,84.82159540 ,169.6431908 ,339.2863816 ,678.5727632 ,1357.145526 ,2714.291053 ,5428.582105},
            {21.82676446 ,43.65352893 ,87.30705786 ,174.6141157 ,349.2282314 ,698.4564629 ,1396.912926 ,2793.825851 ,5587.651703},
            {22.46633748 ,44.93267496 ,89.86534993 ,179.7306999 ,359.4613997 ,718.9227994 ,1437.845599 ,2875.691198 ,5751.382395},
            {23.12465142 ,46.24930284 ,92.49860568 ,184.9972114 ,369.9944227 ,739.9888454 ,1479.977691 ,2959.955382 ,5919.910763},
            {23.80225543 ,47.60451086 ,95.20902171 ,190.4180434 ,380.8360868 ,761.6721737 ,1523.344347 ,3046.688695 ,6093.377389},
            {24.49971475 ,48.99942950 ,97.99885900 ,195.9977180 ,391.9954360 ,783.9908720 ,1567.981744 ,3135.963488 ,6271.926976},
            {25.21761119 ,50.43522238 ,100.8704448 ,201.7408895 ,403.4817790 ,806.9635580 ,1613.927116 ,3227.854232 ,6455.708464},
            {25.95654360 ,51.91308720 ,103.8261744 ,207.6523488 ,415.3046976 ,830.6093952 ,1661.218790 ,3322.437581 ,6644.875161},
            {26.71712838 ,53.43425676 ,106.8685135 ,213.7370271 ,427.4740541 ,854.9481082 ,1709.896216 ,3419.792433 ,6839.584866},
            {27.50000000 ,55.00000000 ,110.0000000 ,220.0000000 ,440.0000000 ,880.0000000 ,1760.000000 ,3520.000000 ,7040.000000},
            {28.30581151 ,56.61162302 ,113.2232460 ,226.4464921 ,452.8929841 ,905.7859682 ,1811.571936 ,3623.143873 ,7246.287746},
            {29.13523509 ,58.27047019 ,116.5409404 ,233.0818808 ,466.1637615 ,932.3275230 ,1864.655046 ,3729.310092 ,7458.620184},
            {29.98896265 ,59.97792530 ,119.9558506 ,239.9117012 ,479.8234024 ,959.6468047 ,1919.293609 ,3838.587219 ,7677.174438},
            {30.86770633 ,61.73541266 ,123.4708253 ,246.9416506 ,493.8833013 ,987.7666025 ,1975.533205 ,3951.066410 ,7902.132820},
            {31.77219916 ,63.54439833 ,127.0887967 ,254.1775933 ,508.3551866 ,1016.710373 ,2033.420746 ,4066.841493 ,8133.682986}
    };
    public FrequencyTable(){
        setListNadaDasar();
    }

    public NadaDasar getNadaDasar(double param)
    {
        NadaDasar a = new NadaDasar();
        int i = 0;
        boolean iterator = false;
        if (param==-1){
            a.setLowerBound(0);
            a.setUpperBound(0);
            a.setOktaf(0);
            a.setNet_val(0);
            a.setNamaNot("Diam (Tidak ada suara)");
        }else {
            while (!iterator && i < 255) {
                if (nada.get(i).getLowerBound() < param && param < nada.get(i).getUpperBound()) {
                    iterator = true;
                } else {
                    i++;
                }
            }
            a = nada.get(i);
        }
        return a;
    }

    public void setListNadaDasar(){
        nada = new ArrayList<NadaDasar>();
        for (int i = 0; i < base.length ; i++){
            for (int j = 0; j < base[i].length ; j++){
                NadaDasar a = new NadaDasar();
                if(i==1){
                    a.setNamaNot("C");
                    a.setOktaf(j);
                    a.setLowerBound(base[i-1][j]);
                    a.setNet_val(base[i][j]);
                    a.setUpperBound(base[i+1][j]);
                }else if(i==3){
                    a.setNamaNot("C#");
                    a.setOktaf(j);
                    a.setLowerBound(base[i-1][j]);
                    a.setNet_val(base[i][j]);
                    a.setUpperBound(base[i+1][j]);
                }else if(i==5){
                    a.setNamaNot("D");
                    a.setOktaf(j);
                    a.setLowerBound(base[i-1][j]);
                    a.setNet_val(base[i][j]);
                    a.setUpperBound(base[i+1][j]);
                }else if(i==7){
                    a.setNamaNot("D#");
                    a.setOktaf(j);
                    a.setLowerBound(base[i-1][j]);
                    a.setNet_val(base[i][j]);
                    a.setUpperBound(base[i+1][j]);
                }else if(i==9){
                    a.setNamaNot("E");
                    a.setOktaf(j);
                    a.setLowerBound(base[i-1][j]);
                    a.setNet_val(base[i][j]);
                    a.setUpperBound(base[i+1][j]);
                }else if(i==11){
                    a.setNamaNot("F");
                    a.setOktaf(j);
                    a.setLowerBound(base[i-1][j]);
                    a.setNet_val(base[i][j]);
                    a.setUpperBound(base[i+1][j]);
                }else if(i==13){
                    a.setNamaNot("F#");
                    a.setOktaf(j);
                    a.setLowerBound(base[i-1][j]);
                    a.setNet_val(base[i][j]);
                    a.setUpperBound(base[i+1][j]);
                }else if(i==15){
                    a.setNamaNot("G");
                    a.setOktaf(j);
                    a.setLowerBound(base[i-1][j]);
                    a.setNet_val(base[i][j]);
                    a.setUpperBound(base[i+1][j]);
                }else if(i==17){
                    a.setNamaNot("G#");
                    a.setOktaf(j);
                    a.setLowerBound(base[i-1][j]);
                    a.setNet_val(base[i][j]);
                    a.setUpperBound(base[i+1][j]);
                }else if(i==19){
                    a.setNamaNot("A");
                    a.setOktaf(j);
                    a.setLowerBound(base[i-1][j]);
                    a.setNet_val(base[i][j]);
                    a.setUpperBound(base[i+1][j]);
                }else if(i==21){
                    a.setNamaNot("A#");
                    a.setOktaf(j);
                    a.setLowerBound(base[i-1][j]);
                    a.setNet_val(base[i][j]);
                    a.setUpperBound(base[i+1][j]);
                }else if(i==23){
                    a.setNamaNot("B");
                    a.setOktaf(j);
                    a.setLowerBound(base[i-1][j]);
                    a.setNet_val(base[i][j]);
                    a.setUpperBound(base[i+1][j]);
                }
                nada.add(a);
            }
        }
    }

    public List<NadaDasar> getListNadaDasar()
    {
        return nada;
    }

    public NadaDasar getNada(int index)
    {
        return nada.get(index);
    }

}
