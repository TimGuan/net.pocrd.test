// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: net/pocrd/test/core/util/Test_String.proto

package net.pocrd.test.core.util;

public final class TestString {
  private TestString() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
  }
  public interface Test_StringOrBuilder
      extends com.google.protobuf.MessageOrBuilder {

    // optional string str = 1;
    /**
     * <code>optional string str = 1;</code>
     */
    boolean hasStr();
    /**
     * <code>optional string str = 1;</code>
     */
    java.lang.String getStr();
    /**
     * <code>optional string str = 1;</code>
     */
    com.google.protobuf.ByteString
        getStrBytes();
  }
  /**
   * Protobuf type {@code net.pocrd.test.core.util.Test_String}
   */
  public static final class Test_String extends
      com.google.protobuf.GeneratedMessage
      implements Test_StringOrBuilder {
    // Use Test_String.newBuilder() to construct.
    private Test_String(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
      super(builder);
      this.unknownFields = builder.getUnknownFields();
    }
    private Test_String(boolean noInit) { this.unknownFields = com.google.protobuf.UnknownFieldSet.getDefaultInstance(); }

    private static final Test_String defaultInstance;
    public static Test_String getDefaultInstance() {
      return defaultInstance;
    }

    public Test_String getDefaultInstanceForType() {
      return defaultInstance;
    }

    private final com.google.protobuf.UnknownFieldSet unknownFields;
    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
        getUnknownFields() {
      return this.unknownFields;
    }
    private Test_String(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      initFields();
      int mutable_bitField0_ = 0;
      com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder();
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            default: {
              if (!parseUnknownField(input, unknownFields,
                                     extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
            case 10: {
              bitField0_ |= 0x00000001;
              str_ = input.readBytes();
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e.getMessage()).setUnfinishedMessage(this);
      } finally {
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return net.pocrd.test.core.util.TestString.internal_static_net_pocrd_test_core_util_Test_String_descriptor;
    }

    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return net.pocrd.test.core.util.TestString.internal_static_net_pocrd_test_core_util_Test_String_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              net.pocrd.test.core.util.TestString.Test_String.class, net.pocrd.test.core.util.TestString.Test_String.Builder.class);
    }

    public static com.google.protobuf.Parser<Test_String> PARSER =
        new com.google.protobuf.AbstractParser<Test_String>() {
      public Test_String parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new Test_String(input, extensionRegistry);
      }
    };

    @java.lang.Override
    public com.google.protobuf.Parser<Test_String> getParserForType() {
      return PARSER;
    }

    private int bitField0_;
    // optional string str = 1;
    public static final int STR_FIELD_NUMBER = 1;
    private java.lang.Object str_;
    /**
     * <code>optional string str = 1;</code>
     */
    public boolean hasStr() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <code>optional string str = 1;</code>
     */
    public java.lang.String getStr() {
      java.lang.Object ref = str_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          str_ = s;
        }
        return s;
      }
    }
    /**
     * <code>optional string str = 1;</code>
     */
    public com.google.protobuf.ByteString
        getStrBytes() {
      java.lang.Object ref = str_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        str_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    private void initFields() {
      str_ = "";
    }
    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized != -1) return isInitialized == 1;

      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      getSerializedSize();
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        output.writeBytes(1, getStrBytes());
      }
      getUnknownFields().writeTo(output);
    }

    private int memoizedSerializedSize = -1;
    public int getSerializedSize() {
      int size = memoizedSerializedSize;
      if (size != -1) return size;

      size = 0;
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        size += com.google.protobuf.CodedOutputStream
          .computeBytesSize(1, getStrBytes());
      }
      size += getUnknownFields().getSerializedSize();
      memoizedSerializedSize = size;
      return size;
    }

    private static final long serialVersionUID = 0L;
    @java.lang.Override
    protected java.lang.Object writeReplace()
        throws java.io.ObjectStreamException {
      return super.writeReplace();
    }

    public static net.pocrd.test.core.util.TestString.Test_String parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static net.pocrd.test.core.util.TestString.Test_String parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static net.pocrd.test.core.util.TestString.Test_String parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static net.pocrd.test.core.util.TestString.Test_String parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static net.pocrd.test.core.util.TestString.Test_String parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static net.pocrd.test.core.util.TestString.Test_String parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }
    public static net.pocrd.test.core.util.TestString.Test_String parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input);
    }
    public static net.pocrd.test.core.util.TestString.Test_String parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input, extensionRegistry);
    }
    public static net.pocrd.test.core.util.TestString.Test_String parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static net.pocrd.test.core.util.TestString.Test_String parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }

    public static Builder newBuilder() { return Builder.create(); }
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder(net.pocrd.test.core.util.TestString.Test_String prototype) {
      return newBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() { return newBuilder(this); }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessage.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code net.pocrd.test.core.util.Test_String}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessage.Builder<Builder>
       implements net.pocrd.test.core.util.TestString.Test_StringOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return net.pocrd.test.core.util.TestString.internal_static_net_pocrd_test_core_util_Test_String_descriptor;
      }

      protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return net.pocrd.test.core.util.TestString.internal_static_net_pocrd_test_core_util_Test_String_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                net.pocrd.test.core.util.TestString.Test_String.class, net.pocrd.test.core.util.TestString.Test_String.Builder.class);
      }

      // Construct using net.pocrd.test.core.util.TestString.Test_String.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessage.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessage.alwaysUseFieldBuilders) {
        }
      }
      private static Builder create() {
        return new Builder();
      }

      public Builder clear() {
        super.clear();
        str_ = "";
        bitField0_ = (bitField0_ & ~0x00000001);
        return this;
      }

      public Builder clone() {
        return create().mergeFrom(buildPartial());
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return net.pocrd.test.core.util.TestString.internal_static_net_pocrd_test_core_util_Test_String_descriptor;
      }

      public net.pocrd.test.core.util.TestString.Test_String getDefaultInstanceForType() {
        return net.pocrd.test.core.util.TestString.Test_String.getDefaultInstance();
      }

      public net.pocrd.test.core.util.TestString.Test_String build() {
        net.pocrd.test.core.util.TestString.Test_String result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public net.pocrd.test.core.util.TestString.Test_String buildPartial() {
        net.pocrd.test.core.util.TestString.Test_String result = new net.pocrd.test.core.util.TestString.Test_String(this);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
          to_bitField0_ |= 0x00000001;
        }
        result.str_ = str_;
        result.bitField0_ = to_bitField0_;
        onBuilt();
        return result;
      }

      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof net.pocrd.test.core.util.TestString.Test_String) {
          return mergeFrom((net.pocrd.test.core.util.TestString.Test_String)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(net.pocrd.test.core.util.TestString.Test_String other) {
        if (other == net.pocrd.test.core.util.TestString.Test_String.getDefaultInstance()) return this;
        if (other.hasStr()) {
          bitField0_ |= 0x00000001;
          str_ = other.str_;
          onChanged();
        }
        this.mergeUnknownFields(other.getUnknownFields());
        return this;
      }

      public final boolean isInitialized() {
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        net.pocrd.test.core.util.TestString.Test_String parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (net.pocrd.test.core.util.TestString.Test_String) e.getUnfinishedMessage();
          throw e;
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int bitField0_;

      // optional string str = 1;
      private java.lang.Object str_ = "";
      /**
       * <code>optional string str = 1;</code>
       */
      public boolean hasStr() {
        return ((bitField0_ & 0x00000001) == 0x00000001);
      }
      /**
       * <code>optional string str = 1;</code>
       */
      public java.lang.String getStr() {
        java.lang.Object ref = str_;
        if (!(ref instanceof java.lang.String)) {
          java.lang.String s = ((com.google.protobuf.ByteString) ref)
              .toStringUtf8();
          str_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>optional string str = 1;</code>
       */
      public com.google.protobuf.ByteString
          getStrBytes() {
        java.lang.Object ref = str_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          str_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>optional string str = 1;</code>
       */
      public Builder setStr(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000001;
        str_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional string str = 1;</code>
       */
      public Builder clearStr() {
        bitField0_ = (bitField0_ & ~0x00000001);
        str_ = getDefaultInstance().getStr();
        onChanged();
        return this;
      }
      /**
       * <code>optional string str = 1;</code>
       */
      public Builder setStrBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000001;
        str_ = value;
        onChanged();
        return this;
      }

      // @@protoc_insertion_point(builder_scope:net.pocrd.test.core.util.Test_String)
    }

    static {
      defaultInstance = new Test_String(true);
      defaultInstance.initFields();
    }

    // @@protoc_insertion_point(class_scope:net.pocrd.test.core.util.Test_String)
  }

  private static com.google.protobuf.Descriptors.Descriptor
    internal_static_net_pocrd_test_core_util_Test_String_descriptor;
  private static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_net_pocrd_test_core_util_Test_String_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n*net/pocrd/test/core/util/Test_String.p" +
      "roto\022\030net.pocrd.test.core.util\"\032\n\013Test_S" +
      "tring\022\013\n\003str\030\001 \001(\t"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
      new com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner() {
        public com.google.protobuf.ExtensionRegistry assignDescriptors(
            com.google.protobuf.Descriptors.FileDescriptor root) {
          descriptor = root;
          internal_static_net_pocrd_test_core_util_Test_String_descriptor =
            getDescriptor().getMessageTypes().get(0);
          internal_static_net_pocrd_test_core_util_Test_String_fieldAccessorTable = new
            com.google.protobuf.GeneratedMessage.FieldAccessorTable(
              internal_static_net_pocrd_test_core_util_Test_String_descriptor,
              new java.lang.String[] { "Str", });
          return null;
        }
      };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
  }

  // @@protoc_insertion_point(outer_class_scope)
}
