package org.osio.hdd.istio.com;

import io.fabric8.kubernetes.clnt.v3_1.Config;
import me.snowdrop.istio.client.IstioClient;
import me.snowdrop.istio.client.IstioClientFactory;


public class App 
{
    public static void main( String[] args )
    {
    	Config istioConfig = new Config();
        IstioClient istioClient = IstioClientFactory.defaultClient(istioConfig);
        System.out.println( istioConfig.toString() );
    }
}
