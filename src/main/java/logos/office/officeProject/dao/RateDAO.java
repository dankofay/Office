package logos.office.officeProject.dao;
import logos.office.officeProject.model.*;

public interface RateDAO extends ElementDAO<Rate> {

	public Rate findRateByUserRole(Role role);
}
