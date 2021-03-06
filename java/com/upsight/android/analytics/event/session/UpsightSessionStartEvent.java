package com.upsight.android.analytics.event.session;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.upsight.android.analytics.event.UpsightPublisherData;
import com.upsight.android.analytics.internal.AnalyticsEvent;
import com.upsight.android.persistence.annotation.UpsightStorableType;

@UpsightStorableType("upsight.session.start")
public class UpsightSessionStartEvent extends AnalyticsEvent<UpsightData> {

    public static class Builder extends com.upsight.android.analytics.internal.AnalyticsEvent.Builder<UpsightSessionStartEvent, UpsightData> {
        private String referrer;
        private String streamId;
        private String streamStartTs;

        protected Builder() {
        }

        public Builder setStreamStartTs(String streamStartTs) {
            this.streamStartTs = streamStartTs;
            return this;
        }

        public Builder setReferrer(String referrer) {
            this.referrer = referrer;
            return this;
        }

        public Builder setStreamId(String streamId) {
            this.streamId = streamId;
            return this;
        }

        protected UpsightSessionStartEvent build() {
            return new UpsightSessionStartEvent("upsight.session.start", new UpsightData(this), this.mPublisherDataBuilder.build());
        }
    }

    static class UpsightData {
        @SerializedName("referrer")
        @Expose
        String referrer;
        @SerializedName("stream_id")
        @Expose
        String streamId;
        @SerializedName("stream_start_ts")
        @Expose
        String streamStartTs;

        protected UpsightData(Builder builder) {
            this.streamStartTs = builder.streamStartTs;
            this.referrer = builder.referrer;
            this.streamId = builder.streamId;
        }

        protected UpsightData() {
        }

        public String getStreamStartTs() {
            return this.streamStartTs;
        }

        public String getReferrer() {
            return this.referrer;
        }

        public String getStreamId() {
            return this.streamId;
        }
    }

    public static Builder createBuilder() {
        return new Builder();
    }

    protected UpsightSessionStartEvent(String type, UpsightData upsightData, UpsightPublisherData publisherData) {
        super(type, upsightData, publisherData);
    }

    protected UpsightSessionStartEvent() {
    }
}
