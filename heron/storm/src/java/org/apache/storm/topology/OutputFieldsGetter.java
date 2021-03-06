// Copyright 2016 Twitter. All rights reserved.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//    http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package org.apache.storm.topology;

import org.apache.storm.tuple.Fields;
import org.apache.storm.utils.Utils;

public class OutputFieldsGetter implements OutputFieldsDeclarer {
  private com.twitter.heron.api.topology.OutputFieldsDeclarer delegate;

  public OutputFieldsGetter(com.twitter.heron.api.topology.OutputFieldsDeclarer delegate) {
    this.delegate = delegate;
  }

  public void declare(Fields fields) {
    declare(false, fields);
  }

  public void declare(boolean direct, Fields fields) {
    declareStream(Utils.DEFAULT_STREAM_ID, direct, fields);
  }

  public void declareStream(String streamId, Fields fields) {
    declareStream(streamId, false, fields);
  }

  public void declareStream(String streamId, boolean direct, Fields fields) {
    delegate.declareStream(streamId, direct, fields.getDelegate());
  }
}
