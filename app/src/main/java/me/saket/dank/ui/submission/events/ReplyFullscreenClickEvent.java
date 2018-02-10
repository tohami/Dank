package me.saket.dank.ui.submission.events;

import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;

import me.saket.dank.data.ContributionFullNameWrapper;

@AutoValue
public abstract class ReplyFullscreenClickEvent {

  public abstract long replyRowItemId();

  public abstract ContributionFullNameWrapper parentContribution();

  public abstract CharSequence replyMessage();

  @Nullable
  public abstract String authorNameIfComment();

  public static ReplyFullscreenClickEvent create(
      long replyRowItemId,
      ContributionFullNameWrapper parentContribution,
      CharSequence replyMessage,
      String authorNameIfComment)
  {
    return new AutoValue_ReplyFullscreenClickEvent(replyRowItemId, parentContribution, replyMessage, authorNameIfComment);
  }
}
