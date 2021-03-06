// This file was generated by Mendix Studio Pro.
//
// WARNING: Code you write here will be lost the next time you deploy the project.

package myfirstmodule.proxies.microflows;

import java.util.HashMap;
import java.util.Map;
import com.mendix.core.Core;
import com.mendix.core.CoreException;
import com.mendix.systemwideinterfaces.MendixRuntimeException;
import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.systemwideinterfaces.core.IMendixObject;

public class Microflows
{
	// These are the microflows for the MyFirstModule module
	public static void aCT_InitializeData(IContext context)
	{
		Map<java.lang.String, Object> params = new HashMap<>();
		Core.microflowCall("MyFirstModule.ACT_InitializeData").withParams(params).execute(context);
	}
	public static void aCT_Root_ResetJSON(IContext context, myfirstmodule.proxies.Root _root)
	{
		Map<java.lang.String, Object> params = new HashMap<>();
		params.put("Root", _root == null ? null : _root.getMendixObject());
		Core.microflowCall("MyFirstModule.ACT_Root_ResetJSON").withParams(params).execute(context);
	}
	public static myfirstmodule.proxies.Root dS_Root_Cascader2Layer(IContext context)
	{
		Map<java.lang.String, Object> params = new HashMap<>();
		IMendixObject result = (IMendixObject)Core.microflowCall("MyFirstModule.DS_Root_Cascader2Layer").withParams(params).execute(context);
		return result == null ? null : myfirstmodule.proxies.Root.initialize(context, result);
	}
	public static myfirstmodule.proxies.Root dS_Root_Cascader3Layer(IContext context)
	{
		Map<java.lang.String, Object> params = new HashMap<>();
		IMendixObject result = (IMendixObject)Core.microflowCall("MyFirstModule.DS_Root_Cascader3Layer").withParams(params).execute(context);
		return result == null ? null : myfirstmodule.proxies.Root.initialize(context, result);
	}
	public static myfirstmodule.proxies.Root dS_Root_Cascader4Layer(IContext context)
	{
		Map<java.lang.String, Object> params = new HashMap<>();
		IMendixObject result = (IMendixObject)Core.microflowCall("MyFirstModule.DS_Root_Cascader4Layer").withParams(params).execute(context);
		return result == null ? null : myfirstmodule.proxies.Root.initialize(context, result);
	}
	public static myfirstmodule.proxies.Root dS_Root_CascaderDisabledOptions(IContext context)
	{
		Map<java.lang.String, Object> params = new HashMap<>();
		IMendixObject result = (IMendixObject)Core.microflowCall("MyFirstModule.DS_Root_CascaderDisabledOptions").withParams(params).execute(context);
		return result == null ? null : myfirstmodule.proxies.Root.initialize(context, result);
	}
	public static void oCH_Root_Cascader(IContext context, myfirstmodule.proxies.Root _root)
	{
		Map<java.lang.String, Object> params = new HashMap<>();
		params.put("Root", _root == null ? null : _root.getMendixObject());
		Core.microflowCall("MyFirstModule.OCH_Root_Cascader").withParams(params).execute(context);
	}
	public static void sUB_DeleteAllData(IContext context)
	{
		Map<java.lang.String, Object> params = new HashMap<>();
		Core.microflowCall("MyFirstModule.SUB_DeleteAllData").withParams(params).execute(context);
	}
}