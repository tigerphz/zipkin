/*
 * Copyright 2012 Twitter Inc.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */
package com.twitter.zipkin.query.adjusters

import com.twitter.zipkin.common.Span

trait Adjuster {

  /**
   * Adjusts the incoming trace in some way. Could for example be
   * moving timestamps or filling in missing spans.
   */
  def adjust(trace: List[Span]) : List[Span]
}

class AdjusterException extends Exception

object NullAdjuster extends Adjuster {
  def adjust(trace: List[Span]) = trace
}