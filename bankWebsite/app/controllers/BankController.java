package controllers;

import dto.*;
import play.data.Form;
import play.data.FormFactory;
import play.libs.Json;
import play.mvc.*;
import services.*;

import javax.inject.Inject;

import java.util.List;

public class BankController extends Controller {
	
	@Inject
	private FormFactory formFactory;
	
	public Result saveData(Http.Request request) {
		
		// JsonNode jsonNode = request.body().asJson();
		// System.out.println( " json  " + jsonNode);
		
		Form<RegistrationRequest> registrationRequestForm =
				formFactory.form(RegistrationRequest.class).bindFromRequest(request);
		RegistrationRequest registrationRequest = registrationRequestForm.get();
		RegistrationResponse registrationResponse = RegistrationService.save(registrationRequest);
		
		return ok(Json.toJson(registrationResponse));
	}
	
	
	public Result loginCheck(Http.Request request) {
		
		Form<LoginRequest> loginRequestForm =
				formFactory.form(LoginRequest.class).bindFromRequest(request);
		LoginRequest loginRequest = loginRequestForm.get();
		LoginResponse loginResponse = LoginService.validateCredentials(loginRequest);
		
		return ok(Json.toJson(loginResponse));
		
	}
	
	
	public Result profileRender(Http.Request request) {
		
		Form<ProfileDetailsRequest> profileDetailsRequestForm =
				formFactory.form(ProfileDetailsRequest.class).bindFromRequest(request);
		ProfileDetailsRequest profileDetailsRequest = profileDetailsRequestForm.get();
		ProfileDetailsResponse profileDetailsResponse = ProfileDetailsService.renderProfileDetails(profileDetailsRequest);
		return ok(Json.toJson(profileDetailsResponse));
		
	}
	
	
	public Result sendMoney(Http.Request request) {
		
		Form<SendMoneyRequest> sendMoneyRequestForm =
				formFactory.form(SendMoneyRequest.class).bindFromRequest(request);
		SendMoneyRequest sendMoneyRequest = sendMoneyRequestForm.get();
		SendMoneyResponse sendMoneyResponse = SendMoneyService.saveSendingMoneyDetails(sendMoneyRequest);
		
		return ok(Json.toJson(sendMoneyResponse));
		
	}
	
	
	public Result renderAccountStatements(Http.Request request) {
		
		Form<AccountStatementRequest> accountStatementRequestForm =
				formFactory.form(AccountStatementRequest.class).bindFromRequest(request);
		AccountStatementRequest accountStatementRequest = accountStatementRequestForm.get();
		List<AccountStatementResponse> accountStatementResponseList = AccountStatementService.renderAccountStatement(accountStatementRequest);
		
		return ok(Json.toJson(accountStatementResponseList));
		
	}
	
	
	public Result viewList() {

//        Form<ViewListRequest> viewListRequestForm =
//                formFactory.form(ViewListRequest.class).bindFromRequest(request);
//         viewListRequest = viewListRequestForm.get();
		List<ViewListResponse> viewListResponseList = ViewListService.renderViewList();
		
		return ok(Json.toJson(viewListResponseList));
	}
	
	
	public Result deactivateCustomer(Http.Request request) {
		
		Form<DeactivateButtonRequest> deactivateButtonRequestForm =
				formFactory.form(DeactivateButtonRequest.class).bindFromRequest(request);
		DeactivateButtonRequest deactivateButtonRequest = deactivateButtonRequestForm.get();
		DeactivateButtonResponse deactivateButtonResponse = DeactivateButtonService.deactivateCustomer(deactivateButtonRequest);
		
		return ok(Json.toJson(deactivateButtonResponse));
	}
	
	
	public Result activateCustomer(Http.Request request){
		
		Form<ActivateButtonRequest> activateButtonRequestForm =
				formFactory.form(ActivateButtonRequest.class).bindFromRequest(request);
		ActivateButtonRequest activateButtonRequest = activateButtonRequestForm.get();
		ActivateButtonResponse activateButtonResponse = ActivateButtonService.activateCustomer(activateButtonRequest);
		
		return ok(Json.toJson(activateButtonResponse));
	}
	
	
	public Result customerFeedback(Http.Request request) {
		
		Form<FeedbackRequest> feedbackRequestForm =
				formFactory.form(FeedbackRequest.class).bindFromRequest(request);
		FeedbackRequest feedbackRequest = feedbackRequestForm.get();
		FeedbackResponse feedbackResponse = FeedbackService.customerFeedback(feedbackRequest);
		
		return ok(Json.toJson(feedbackResponse));
	}
	
	public Result feedbackReview() {
		
		List<FeedbackReviewResponse> feedbackResponseList = FeedbackReviewService.renderFeedback();
		return ok(Json.toJson(feedbackResponseList));
		
	}
}
