package me.saket.dank.data;

import android.support.annotation.Nullable;

import net.dean.jraw.models.Comment;

import me.saket.dank.ui.submission.PendingSyncReply;

public class LocallyPostedComment extends Comment {

  private final PendingSyncReply pendingSyncReply;

  public static LocallyPostedComment create(PendingSyncReply pendingSyncReply) {
    return new LocallyPostedComment(pendingSyncReply);
  }

  private LocallyPostedComment(PendingSyncReply pendingSyncReply) {
    super(null);
    this.pendingSyncReply = pendingSyncReply;
  }

  @Nullable
  @Override
  public String getFullName() {
    return pendingSyncReply.postedFullName();
  }

  @Override
  public String getAuthor() {
    return pendingSyncReply.author();
  }

  @Override
  public String getBody() {
    return pendingSyncReply.body();
  }

  public String getPostingStatusIndependentId() {
    return pendingSyncReply.parentContributionFullName() + "_reply_" + pendingSyncReply.createdTimeMillis();
  }

  public PendingSyncReply pendingSyncReply() {
    return pendingSyncReply;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof LocallyPostedComment)) {
      return false;
    }
    LocallyPostedComment that = (LocallyPostedComment) o;
    return pendingSyncReply.equals(that.pendingSyncReply);
  }

  @Override
  public int hashCode() {
    return pendingSyncReply.hashCode();
  }
}
