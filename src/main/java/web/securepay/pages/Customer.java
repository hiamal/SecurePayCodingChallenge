package web.securepay.pages;

public class Customer {
	public String firstName;
	public String lastName;
	public String email;
	public String phone;
	public String company;
	public String url;
	public String message;
	
	@Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        final Customer other = (Customer) obj;
        
        return this.firstName.equals(other.firstName) && 
        		this.lastName.equals(other.lastName) && 
        		this.email.equals(other.email) && 
        		this.phone.equals(other.phone) &&  
        		this.company.equals(other.company) && 
        		this.url.equals(other.url) && 
        		this.message.equals(other.message);
    }
}
