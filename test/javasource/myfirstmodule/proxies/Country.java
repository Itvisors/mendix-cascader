// This file was generated by Mendix Studio Pro.
//
// WARNING: Code you write here will be lost the next time you deploy the project.

package myfirstmodule.proxies;

public class Country
{
	private final com.mendix.systemwideinterfaces.core.IMendixObject countryMendixObject;

	private final com.mendix.systemwideinterfaces.core.IContext context;

	/**
	 * Internal name of this entity
	 */
	public static final java.lang.String entityName = "MyFirstModule.Country";

	/**
	 * Enum describing members of this entity
	 */
	public enum MemberNames
	{
		Value("Value"),
		Label("Label"),
		Country_Continent("MyFirstModule.Country_Continent");

		private java.lang.String metaName;

		MemberNames(java.lang.String s)
		{
			metaName = s;
		}

		@java.lang.Override
		public java.lang.String toString()
		{
			return metaName;
		}
	}

	public Country(com.mendix.systemwideinterfaces.core.IContext context)
	{
		this(context, com.mendix.core.Core.instantiate(context, "MyFirstModule.Country"));
	}

	protected Country(com.mendix.systemwideinterfaces.core.IContext context, com.mendix.systemwideinterfaces.core.IMendixObject countryMendixObject)
	{
		if (countryMendixObject == null)
			throw new java.lang.IllegalArgumentException("The given object cannot be null.");
		if (!com.mendix.core.Core.isSubClassOf("MyFirstModule.Country", countryMendixObject.getType()))
			throw new java.lang.IllegalArgumentException("The given object is not a MyFirstModule.Country");

		this.countryMendixObject = countryMendixObject;
		this.context = context;
	}

	/**
	 * @deprecated Use 'Country.load(IContext, IMendixIdentifier)' instead.
	 */
	@java.lang.Deprecated
	public static myfirstmodule.proxies.Country initialize(com.mendix.systemwideinterfaces.core.IContext context, com.mendix.systemwideinterfaces.core.IMendixIdentifier mendixIdentifier) throws com.mendix.core.CoreException
	{
		return myfirstmodule.proxies.Country.load(context, mendixIdentifier);
	}

	/**
	 * Initialize a proxy using context (recommended). This context will be used for security checking when the get- and set-methods without context parameters are called.
	 * The get- and set-methods with context parameter should be used when for instance sudo access is necessary (IContext.createSudoClone() can be used to obtain sudo access).
	 */
	public static myfirstmodule.proxies.Country initialize(com.mendix.systemwideinterfaces.core.IContext context, com.mendix.systemwideinterfaces.core.IMendixObject mendixObject)
	{
		return new myfirstmodule.proxies.Country(context, mendixObject);
	}

	public static myfirstmodule.proxies.Country load(com.mendix.systemwideinterfaces.core.IContext context, com.mendix.systemwideinterfaces.core.IMendixIdentifier mendixIdentifier) throws com.mendix.core.CoreException
	{
		com.mendix.systemwideinterfaces.core.IMendixObject mendixObject = com.mendix.core.Core.retrieveId(context, mendixIdentifier);
		return myfirstmodule.proxies.Country.initialize(context, mendixObject);
	}

	public static java.util.List<myfirstmodule.proxies.Country> load(com.mendix.systemwideinterfaces.core.IContext context, java.lang.String xpathConstraint) throws com.mendix.core.CoreException
	{
		java.util.List<myfirstmodule.proxies.Country> result = new java.util.ArrayList<myfirstmodule.proxies.Country>();
		for (com.mendix.systemwideinterfaces.core.IMendixObject obj : com.mendix.core.Core.retrieveXPathQuery(context, "//MyFirstModule.Country" + xpathConstraint))
			result.add(myfirstmodule.proxies.Country.initialize(context, obj));
		return result;
	}

	/**
	 * Commit the changes made on this proxy object.
	 */
	public final void commit() throws com.mendix.core.CoreException
	{
		com.mendix.core.Core.commit(context, getMendixObject());
	}

	/**
	 * Commit the changes made on this proxy object using the specified context.
	 */
	public final void commit(com.mendix.systemwideinterfaces.core.IContext context) throws com.mendix.core.CoreException
	{
		com.mendix.core.Core.commit(context, getMendixObject());
	}

	/**
	 * Delete the object.
	 */
	public final void delete()
	{
		com.mendix.core.Core.delete(context, getMendixObject());
	}

	/**
	 * Delete the object using the specified context.
	 */
	public final void delete(com.mendix.systemwideinterfaces.core.IContext context)
	{
		com.mendix.core.Core.delete(context, getMendixObject());
	}
	/**
	 * @return value of Value
	 */
	public final java.lang.String getValue()
	{
		return getValue(getContext());
	}

	/**
	 * @param context
	 * @return value of Value
	 */
	public final java.lang.String getValue(com.mendix.systemwideinterfaces.core.IContext context)
	{
		return (java.lang.String) getMendixObject().getValue(context, MemberNames.Value.toString());
	}

	/**
	 * Set value of Value
	 * @param value
	 */
	public final void setValue(java.lang.String value)
	{
		setValue(getContext(), value);
	}

	/**
	 * Set value of Value
	 * @param context
	 * @param value
	 */
	public final void setValue(com.mendix.systemwideinterfaces.core.IContext context, java.lang.String value)
	{
		getMendixObject().setValue(context, MemberNames.Value.toString(), value);
	}

	/**
	 * @return value of Label
	 */
	public final java.lang.String getLabel()
	{
		return getLabel(getContext());
	}

	/**
	 * @param context
	 * @return value of Label
	 */
	public final java.lang.String getLabel(com.mendix.systemwideinterfaces.core.IContext context)
	{
		return (java.lang.String) getMendixObject().getValue(context, MemberNames.Label.toString());
	}

	/**
	 * Set value of Label
	 * @param label
	 */
	public final void setLabel(java.lang.String label)
	{
		setLabel(getContext(), label);
	}

	/**
	 * Set value of Label
	 * @param context
	 * @param label
	 */
	public final void setLabel(com.mendix.systemwideinterfaces.core.IContext context, java.lang.String label)
	{
		getMendixObject().setValue(context, MemberNames.Label.toString(), label);
	}

	/**
	 * @return value of Country_Continent
	 */
	public final myfirstmodule.proxies.Continent getCountry_Continent() throws com.mendix.core.CoreException
	{
		return getCountry_Continent(getContext());
	}

	/**
	 * @param context
	 * @return value of Country_Continent
	 */
	public final myfirstmodule.proxies.Continent getCountry_Continent(com.mendix.systemwideinterfaces.core.IContext context) throws com.mendix.core.CoreException
	{
		myfirstmodule.proxies.Continent result = null;
		com.mendix.systemwideinterfaces.core.IMendixIdentifier identifier = getMendixObject().getValue(context, MemberNames.Country_Continent.toString());
		if (identifier != null)
			result = myfirstmodule.proxies.Continent.load(context, identifier);
		return result;
	}

	/**
	 * Set value of Country_Continent
	 * @param country_continent
	 */
	public final void setCountry_Continent(myfirstmodule.proxies.Continent country_continent)
	{
		setCountry_Continent(getContext(), country_continent);
	}

	/**
	 * Set value of Country_Continent
	 * @param context
	 * @param country_continent
	 */
	public final void setCountry_Continent(com.mendix.systemwideinterfaces.core.IContext context, myfirstmodule.proxies.Continent country_continent)
	{
		if (country_continent == null)
			getMendixObject().setValue(context, MemberNames.Country_Continent.toString(), null);
		else
			getMendixObject().setValue(context, MemberNames.Country_Continent.toString(), country_continent.getMendixObject().getId());
	}

	/**
	 * @return the IMendixObject instance of this proxy for use in the Core interface.
	 */
	public final com.mendix.systemwideinterfaces.core.IMendixObject getMendixObject()
	{
		return countryMendixObject;
	}

	/**
	 * @return the IContext instance of this proxy, or null if no IContext instance was specified at initialization.
	 */
	public final com.mendix.systemwideinterfaces.core.IContext getContext()
	{
		return context;
	}

	@java.lang.Override
	public boolean equals(Object obj)
	{
		if (obj == this)
			return true;

		if (obj != null && getClass().equals(obj.getClass()))
		{
			final myfirstmodule.proxies.Country that = (myfirstmodule.proxies.Country) obj;
			return getMendixObject().equals(that.getMendixObject());
		}
		return false;
	}

	@java.lang.Override
	public int hashCode()
	{
		return getMendixObject().hashCode();
	}

	/**
	 * @return String name of this class
	 */
	public static java.lang.String getType()
	{
		return "MyFirstModule.Country";
	}

	/**
	 * @return String GUID from this object, format: ID_0000000000
	 * @deprecated Use getMendixObject().getId().toLong() to get a unique identifier for this object.
	 */
	@java.lang.Deprecated
	public java.lang.String getGUID()
	{
		return "ID_" + getMendixObject().getId().toLong();
	}
}
