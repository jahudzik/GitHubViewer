package com.jahu.githubviewer.usersearch;

import com.jahu.githubviewer.data.users.User;
import com.jahu.githubviewer.data.users.UsersDataSource;
import java.util.Date;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

public class UserSearchPresenterTest {

  private UserSearchPresenter presenter;

  @Mock
  UserSearchContract.View viewMock;

  @Mock
  UsersDataSource dataSourceMock;

  @Before
  public void setUp() {
    MockitoAnnotations.initMocks(this);
    presenter = new UserSearchPresenter(viewMock, dataSourceMock);
    verify(viewMock).setPresenter(presenter);
  }

  @Test
  public void findUser_correctValue() {
    String username = "john";
    presenter.findUser(username);
    verify(viewMock).showLoading();
    verify(dataSourceMock).findUser(username, presenter);
  }

  @Test
  public void findUser_empty() {
    presenter.findUser("");
    verify(viewMock).showError(eq("User name cannot be empty"));
  }

  @Test
  public void findUser_nullValue() {
    presenter.findUser(null);
    verify(viewMock).showError(eq("User name cannot be empty"));
  }

  @Test
  public void onUserFound() {
    User user = new User("Andy", "and", "", "Google", "London", 7, new Date(2009, 11, 9), 67);
    presenter.onUserFound(user);
    verify(viewMock).stopLoading();
    verify(viewMock).showUserDetails(eq("User found: Andy"), eq(user));
  }

  @Test
  public void onUserNotFound() {
    presenter.onUserNotFound();
    verify(viewMock).stopLoading();
    verify(viewMock).showError(eq("User not found"));
  }

  @Test
  public void onError() {
    String errorMessage = "Some error";
    presenter.onError(errorMessage);
    verify(viewMock).stopLoading();
    verify(viewMock).showError(eq(errorMessage));
  }

}