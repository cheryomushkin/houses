package houses.aspect;

import houses.domain.House;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class LoggingAspect {

    private final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(* houses.service.HouseService.all(..))")
    public void logBeforeGetAllHouses(JoinPoint joinPoint) {
        logInfo(joinPoint, "A list of all houses has been requested.");
    }

    @Before("execution(* houses.service.HouseService.add(houses.domain.House)) && args(house)")
    public void logBeforeAddHouse(JoinPoint joinPoint, House house) {
        logInfo(joinPoint, String.format("Adding a new house with name \"%1$s\" and address \"%2$s\" ...", house.getName(), house.getAddress()));
    }

    @Before("execution(* houses.service.HouseService.update(houses.domain.House)) && args(house)")
    public void logBeforeUpdateHouse(JoinPoint joinPoint, House house) {
        logInfo(joinPoint, String.format("Updating a house with name \"%1$s\" ...", house.getName()));
    }

    @Before("execution(* houses.service.HouseService.delete(Long)) && args(houseId)")
    public void logBeforeDeleteHouse(JoinPoint joinPoint, Long houseId) {
        logInfo(joinPoint, String.format("Deleting a house with id \"%1$s\" ...", houseId));
    }

    @Before("execution(* houses.service.HouseService.get(Long)) && args(houseId)")
    public void logBeforeGetHouse(JoinPoint joinPoint, Long houseId) {
        logInfo(joinPoint, String.format("Obtaining a house with id \"%1$s\" ...", houseId));
    }

    private void logInfo(JoinPoint joinPoint, String message) {
        logger.info("[{}.{}]: {}", joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName(), message);
    }

}
