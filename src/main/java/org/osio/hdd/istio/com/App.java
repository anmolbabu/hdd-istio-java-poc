package org.osio.hdd.istio.com;

//import io.fabric8.kubernetes.api.model.v3_1.Pod;
//import io.fabric8.kubernetes.api.model.v3_1.Service;
//import io.fabric8.kubernetes.api.model.v3_1.apiextensions.CustomResourceDefinition;
import io.fabric8.kubernetes.clnt.v3_1.Config;
import io.fabric8.kubernetes.clnt.v3_1.KubernetesClient;
//import me.snowdrop.istio.api.model.IstioResource;
import me.snowdrop.istio.client.IstioClient;
import me.snowdrop.istio.client.IstioClientFactory;

import java.io.InputStream;
import java.nio.file.*;

public class App 
{
	public static String readFileAsString(String fileName)throws Exception
	{
		String data = "";
		data = new String(Files.readAllBytes(Paths.get(fileName)));
		return data;
	}

    public static void main( String[] args )
    {
    	Config istioConfig = new Config();
    	istioConfig.setApiVersion("config.istio.io/v1alpha2");
        //istioConfig.setApiVersion("v1");
    	istioConfig.setMasterUrl("https://172.30.0.1");
    	istioConfig.setTrustCerts(true);
    	istioConfig.setOauthToken("vlJNtTSfowe9Y_m8O17f9z9y4jFB0Zbq-I9aQeiJAPo");
    	istioConfig.setNamespace("istio-system");
        IstioClient istioClient = IstioClientFactory.defaultClient(istioConfig);
        //KubernetesClient kubernetesClient = istioClient.getKubernetesClient();
        /*for (Pod pod : istioClient.getKubernetesClient().pods().list().getItems()) {
			System.out.println(pod.toString() + "\n\n\n");
		}
        for (Service service: kubernetesClient.services().list().getItems()) {
        	System.out.println(service.toString()+ "\n\n");
        }*/
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream is = classloader.getResourceAsStream("metric.yaml");
        try {
			istioClient.registerCustomResources(is);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
